package com.shoalter.ecmmerce.languagesearchservice.service;

import com.shoalter.ecmmerce.languagesearchservice.constants.Constant;
import com.shoalter.ecmmerce.languagesearchservice.utils.CsvUtils;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class CheckService {

    public static void run() {
        csvDataCheck();
        specificPathCheck();
    }

    // 指定目錄字串
    private static final List<String> keywords = List.of(
            "dao",
            "repository",
            "impl",
            "Impl",
            "facade",
            "service",
            "populator",
            "grpc",
            "filter",
            "config",
            "rule",
            "util",
            "utils");

    private static void csvDataCheck() {
        try {
            // 取得目錄下所有 CSV 檔案
            List<Path> csvFiles = CsvUtils.getCsvFiles(Constant.REPORT_PATH);

            for (Path csvFile : csvFiles) {
                // 讀取 CSV 檔案
                List<String[]> rows = CsvUtils.readCsvFile(csvFile);

                // 取得欄位標題 (跳過第一列)
                String[] headers = rows.get(0);
                List<String[]> csvData = rows.subList(1, rows.size());

                // 找到索引
                int filePathIndex = getIndex(headers, CsvUtils.CSV_COLUMN_LIST.get(1));
                int methodNameIndex = getIndex(headers, CsvUtils.CSV_COLUMN_LIST.get(2));

                Map<String, List<Integer>> combinedRowData = getCombinedRowData(csvData, filePathIndex, methodNameIndex);
                Map<Integer, String> rowDictionary = getRowDictionary(csvData, filePathIndex, methodNameIndex);
                System.out.println("總共有" + rowDictionary.size() + " 筆資料\n");

                showDifferentData(combinedRowData, rowDictionary);

                if (combinedRowData.size() == csvData.size()) {
                    System.out.println("檔案：" + csvFile.getFileName() + " 沒有重複的資料\n");
                } else {
//                    showDuplicateData(csvFile, combinedRowData);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Map<Integer, String> getRowDictionary(List<String[]> csvData, int filePathIndex, int methodNameIndex) {
        Map<Integer, String> dictionary = new HashMap<>();
        for (int i = 0; i < csvData.size(); i++) {
            String[] row = csvData.get(i);
            String filePath = row[filePathIndex];
            String methodName = row[methodNameIndex];
            String combined = filePath + "|" + methodName;
            dictionary.put(i + 2, combined);
        }
        return dictionary;
    }

    private static void showDifferentData(Map<String, List<Integer>> combinedValues, Map<Integer, String> dictionary) {
        int i = 1;
        for (Map.Entry<String, List<Integer>> entry : combinedValues.entrySet()) {
            List<Integer> value = entry.getValue();
            if (value.size() == 1) {
                Integer lineNumber = value.get(0);
                if (lineNumber > 507) {
                    String filePath = dictionary.get(lineNumber).split("\\|")[0];
                    String methodName = dictionary.get(lineNumber).split("\\|")[1];
                    System.out.println("第" + i + "個不重複的新資料");
                    System.out.println("位置: " + filePath);
                    System.out.println("方法: " + methodName);
                    System.out.println("行號: " + lineNumber + "\n");
                    i++;
                }
            }
        }
    }

    private static void showDuplicateData(Path csvFile, Map<String, List<Integer>> combinedValues) {
        System.out.println("檔案: " + csvFile.getFileName() + " 有重複的資料");
        combinedValues.entrySet()
                .stream()
                .filter(entry -> entry.getValue().size() > 1)
                .forEach(entry -> {
                    String key = entry.getKey();
                    System.out.println("位置: " + key.split("\\|")[0]);
                    System.out.println("方法: " + key.split("\\|")[1]);
                    System.out.println("行號: " + entry.getValue() + "\n");
                });
    }

    private static Map<String, List<Integer>> getCombinedRowData(List<String[]> csvData, int filePathIndex, int methodNameIndex) {
        Map<String, List<Integer>> combinedValues = new HashMap<>();
        for (int i = 0; i < csvData.size(); i++) {
            String[] row = csvData.get(i);
            String combined = row[filePathIndex] + "|" + row[methodNameIndex];
            String combinedWithoutSpace = combined.replaceAll("\\s", "");
            combinedValues.computeIfAbsent(combinedWithoutSpace, k -> new ArrayList<>()).add(i + 2); // 記錄行號 (從 2 開始)
        }
        return combinedValues;
    }

    // 找到標題的索引
    public static int getIndex(String[] headers, String columnName) {
        for (int i = 0; i < headers.length; i++) {
            if (headers[i].equalsIgnoreCase(columnName)) {
                return i;
            }
        }
        throw new IllegalArgumentException("找到不到欄位: " + columnName);
    }

    private static void specificPathCheck() {
        try {
            // 取得目錄下所有 CSV 檔案
            List<Path> csvFiles = CsvUtils.getCsvFiles(Constant.REPORT_PATH);

            for (Path csvFile : csvFiles) {
                System.out.println("檢查檔案: " + csvFile.getFileName());

                // 讀取 CSV 檔案
                List<String[]> rows = CsvUtils.readCsvFile(csvFile);

                // 取得欄位標題 (跳過第一列)
                String[] headers = rows.get(0);
                List<String[]> data = rows.subList(1, rows.size());

                // 找到索引
                int serviceNameIndex = getIndex(headers, CsvUtils.CSV_COLUMN_LIST.get(0));
                int filePathIndex = getIndex(headers, CsvUtils.CSV_COLUMN_LIST.get(1));
                int methodNameIndex = getIndex(headers, CsvUtils.CSV_COLUMN_LIST.get(2));

                // 檢查不包含特定字串的 File Path
                Predicate<String[]> predicate = row -> {
                    String filePath = row[filePathIndex];
                    return keywords.stream().noneMatch(filePath::contains);
                };

                long count = data.stream().filter(predicate).count();
                if (count == 0) {
                    System.out.println("都在指定目錄中\n");
                    continue;
                }

                System.out.println("有" + count + "筆資料不在指定目錄中");
                data.stream().filter(predicate)
                        .forEach(row -> {
                            System.out.println("服務: " + row[serviceNameIndex]);
                            System.out.println("位置: " + row[filePathIndex]);
                            System.out.println("方法: " + row[methodNameIndex]);
                            System.out.println();
                        });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

