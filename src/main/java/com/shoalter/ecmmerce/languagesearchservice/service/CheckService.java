package com.shoalter.ecmmerce.languagesearchservice.service;

import com.shoalter.ecmmerce.languagesearchservice.constants.Constant;
import com.shoalter.ecmmerce.languagesearchservice.utils.CsvUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

@Slf4j
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
                log.info("[csvDataCheck] 總共有{}筆資料", rowDictionary.size());

                showDifferentData(combinedRowData, rowDictionary);

                if (combinedRowData.size() == csvData.size()) {
                    log.info("[csvDataCheck] 檔案：{}沒有重複的資料", csvFile.getFileName());
                } else {
//                    showDuplicateData(csvFile, combinedRowData);
                }
            }
        } catch (Exception e) {
            log.error("[csvDataCheck] Stack:[{}]", ExceptionUtils.getStackTrace(e));
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
                    log.info("[showDifferentData] 第{}個不重複的新資料", i);
                    log.info("[showDifferentData] 位置:{}", filePath);
                    log.info("[showDifferentData] 方法:{}", methodName);
                    log.info("[showDifferentData] 行號:{}", lineNumber);
                    i++;
                }
            }
        }
    }

    private static void showDuplicateData(Path csvFile, Map<String, List<Integer>> combinedValues) {
        log.info("[showDuplicateData] 檔案:{} 有重複的資料", csvFile.getFileName());
        combinedValues.entrySet()
                .stream()
                .filter(entry -> entry.getValue().size() > 1)
                .forEach(entry -> {
                    String key = entry.getKey();
                    log.info("[showDuplicateData] 位置:{}", key.split("\\|")[0]);
                    log.info("[showDuplicateData] 方法:{}", key.split("\\|")[1]);
                    log.info("[showDuplicateData] 行號:{}", entry.getValue());
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
                log.info("[specificPathCheck] 檢查檔案:{}", csvFile.getFileName());

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
                    log.info("[specificPathCheck] 都在指定目錄中");
                    continue;
                }

                log.info("[specificPathCheck] 有{}筆資料不在指定目錄中", count);
                data.stream().filter(predicate)
                        .forEach(row -> {
                            log.info("[specificPathCheck] 服務:{}", row[serviceNameIndex]);
                            log.info("[specificPathCheck] 位置:{}", row[filePathIndex]);
                            log.info("[specificPathCheck] 方法:{}", row[methodNameIndex]);
                        });
            }
        } catch (Exception e) {
            log.error("[specificPathCheck] Stack:[{}]", ExceptionUtils.getStackTrace(e));
        }
    }
}

