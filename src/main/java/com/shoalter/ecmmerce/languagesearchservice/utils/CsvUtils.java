package com.shoalter.ecmmerce.languagesearchservice.utils;

import com.shoalter.ecmmerce.languagesearchservice.constants.Constant;
import com.shoalter.ecmmerce.languagesearchservice.dto.SearchResultDto;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CsvUtils {

    public static final List<String> CSV_COLUMN_LIST = List.of(
            "Service Name",
            "File Path",
            "Method Name",
            "SQL / Keyword");

    public static final String LINE_WRAP = "\n";

    public static void generateCSV(Map<String, List<SearchResultDto>> results, String strategyName) throws IOException {
        String csvFileName = String.format("search_%s_results_%s.csv", strategyName, System.currentTimeMillis());
        FileWriter fw = new FileWriter(Constant.REPORT_PATH + "\\" + csvFileName);
        BufferedWriter bw = new BufferedWriter(fw);

        // 寫入 CSV 標題行
        bw.write(getCsvColumn());

        // 遍歷結果並寫入 CSV
        for (Map.Entry<String, List<SearchResultDto>> entry : results.entrySet()) {
            String serviceName = entry.getKey();
            List<SearchResultDto> searchResults = entry.getValue();

            for (SearchResultDto result : searchResults) {
                // 轉義 CSV 中的逗號和換行符號
                String className = extractPathAfterSrc(result.className());
                String methodName = result.methodName().replaceAll("[\\n\\r]", " ").replaceAll(",", " ");
                String keyword = result.keyword().replaceAll("[\\n\\r]", " ").replaceAll(",", " ");

                // 寫入每一行
                bw.write(String.format("\"%s\",\"%s\",\"%s\",\"%s\"\n",
                        serviceName, className, methodName, keyword));
            }
        }

        // 關閉 BufferedWriter
        bw.close();
        fw.close();
    }

    private static String getCsvColumn() {
        return CSV_COLUMN_LIST.stream()
                .map(String::trim) // 移除多餘空白和換行符號
                .collect(Collectors.joining(",")) + LINE_WRAP;
    }

    private static String extractPathAfterSrc(String fullPath) {
        String marker = "src";
        int index = fullPath.indexOf(marker);
        if (index != -1) {
            return fullPath.substring(index);
        }
        return fullPath;
    }

    public static List<Path> getCsvFiles(String directoryPath) throws IOException {
        return Files.list(Paths.get(directoryPath))
                .filter(path -> path.toString().endsWith(".csv"))
                .collect(Collectors.toList());
    }

    public static void combineCsvFiles(String directoryPath) {
        // 定義文件的名稱前綴
        String i18nPrefix = "search_i18n_results_";
        String repositoryPrefix = "search_repository_results_";

        try {
            // 取得目錄下所有檔案
            List<Path> files = getCsvFiles(directoryPath);

            // 找到最接近當前時間的檔案
            Path i18nFile = findCurrentTimeClosestFile(files, i18nPrefix);
            Path repositoryFile = findCurrentTimeClosestFile(files, repositoryPrefix);

            if (i18nFile == null || repositoryFile == null) {
                System.out.println("未找到所需檔案，請檢查目錄內容");
                return;
            }

            System.out.println("合併檔案:");
            System.out.println(i18nFile.getFileName());
            System.out.println(repositoryFile.getFileName());

            // 讀取並合併資料
            List<String[]> i18nData = readCsvFile(i18nFile);
            List<String[]> repositoryData = readCsvFile(repositoryFile);

            // 合併資料（跳過標題，保留唯一標題）
            List<String[]> combinedData = new ArrayList<>();
            combinedData.add(i18nData.get(0)); // 標題行
            combinedData.addAll(i18nData.subList(1, i18nData.size()));
            combinedData.addAll(repositoryData.subList(1, repositoryData.size()));

            // 輸出結果
            String outputFileName = "search_all_results_" + System.currentTimeMillis() + ".csv";
            writeCsvFile(Paths.get(directoryPath, outputFileName), combinedData);
            System.out.println("合併完成:\n" + outputFileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Path findCurrentTimeClosestFile(List<Path> files, String prefix) {
        long currentTime = System.currentTimeMillis();
        return files.stream()
                .filter(path -> path.getFileName().toString().startsWith(prefix))
                .min(Comparator.comparingLong(path -> {
                    String timestampPart = path.getFileName()
                            .toString()
                            .replace(prefix, "")
                            .replace(".csv", "");
                    return Math.abs(currentTime - Long.parseLong(timestampPart));
                }))
                .orElse(null);
    }

    public static List<String[]> readCsvFile(Path filePath) throws IOException {
        List<String[]> rows = new ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(filePath)) {
            String line;
            while ((line = br.readLine()) != null) {
                rows.add(line.split(",", -1)); // -1 保留空白欄位
            }
        }
        return rows;
    }

    public static void writeCsvFile(Path outputPath, List<String[]> data) throws IOException {
        try (BufferedWriter bw = Files.newBufferedWriter(outputPath)) {
            for (String[] row : data) {
                bw.write(String.join(",", row));
                bw.newLine();
            }
        }
    }

    public static void generateReport() {
        File directory = new File(Constant.REPORT_PATH);

        if (!directory.exists()) {
            directory.mkdirs();
        }
    }
}
