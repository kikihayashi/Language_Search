package com.shoalter.ecmmerce.languagesearchservice.utils;

import com.shoalter.ecmmerce.languagesearchservice.dto.SearchResultDto;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;

@Slf4j
public class PrintUtils {

    public static void printResult(Map<String, List<SearchResultDto>> results) {
        if (results.isEmpty()) {
            log.info("[printResult] 未找到任何結果");
        } else {
            results.forEach((serviceName, searchResultDtoList) -> {
                String nowClassName = "";
                int index = 1;
                for (SearchResultDto searchResultDto : searchResultDtoList) {
                    if (nowClassName.isEmpty() || !nowClassName.equals(searchResultDto.className())) {
                        nowClassName = searchResultDto.className();
                        log.info("[printResult]--------------------------------------------------------------------------------");
                        log.info("[printResult] Service: {}", serviceName);
                        log.info("[printResult] FilePath: {}", nowClassName);
                        log.info("[printResult] Method: ");
                        index = 1;
                    }
                    log.info("[printResult]       {}  . {}", (index++), searchResultDto.methodName());
                    log.info("[printResult]      --> keyword: {}", searchResultDto.keyword().trim());
                }
            });
        }
    }

    public static void showExecuteStrategy(String strategyName) {
        log.info("[printResult] 執行策略：{}", strategyName);
    }
}
