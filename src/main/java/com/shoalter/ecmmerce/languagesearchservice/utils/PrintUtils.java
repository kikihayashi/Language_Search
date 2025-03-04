package com.shoalter.ecmmerce.languagesearchservice.utils;

import com.shoalter.ecmmerce.languagesearchservice.dto.SearchResultDto;

import java.util.List;
import java.util.Map;

public class PrintUtils {

    public static void printResult(Map<String, List<SearchResultDto>> results) {
        if (results.isEmpty()) {
            System.out.println("未找到任何結果");
        } else {
            results.forEach((serviceName, searchResultDtoList) -> {
                String nowClassName = "";
                int index = 1;
                for (SearchResultDto searchResultDto : searchResultDtoList) {
                    if (nowClassName.isEmpty() || !nowClassName.equals(searchResultDto.className())) {
                        nowClassName = searchResultDto.className();
                        System.out.println("--------------------------------------------------------------------------------");
                        System.out.println("Service: " + serviceName);
                        System.out.println("FilePath: " + nowClassName);
                        System.out.println("Method: ");
                        index = 1;
                    }
                    System.out.println("    " + (index++) + ". " + searchResultDto.methodName());
                    System.out.println("     --> keyword: " + searchResultDto.keyword().trim());
                }
            });
        }
    }

    public static void showExecuteStrategy(String strategyName) {
        System.out.println("執行策略：" + strategyName);
    }
}
