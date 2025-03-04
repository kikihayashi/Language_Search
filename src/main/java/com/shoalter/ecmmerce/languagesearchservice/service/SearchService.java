package com.shoalter.ecmmerce.languagesearchservice.service;

import com.shoalter.ecmmerce.languagesearchservice.constants.Constant;
import com.shoalter.ecmmerce.languagesearchservice.dto.SearchResultDto;
import com.shoalter.ecmmerce.languagesearchservice.strategy.I18nSearchStrategy;
import com.shoalter.ecmmerce.languagesearchservice.strategy.RepositorySearchStrategy;
import com.shoalter.ecmmerce.languagesearchservice.strategy.SearchStrategy;
import com.shoalter.ecmmerce.languagesearchservice.utils.CsvUtils;
import com.shoalter.ecmmerce.languagesearchservice.utils.PrintUtils;

import java.util.List;
import java.util.Map;

public class SearchService {

    private static final List<SearchStrategy> searchStratrgyList = List.of(
            new RepositorySearchStrategy(),
            new I18nSearchStrategy()
    );

    public static void run() {
        searchStratrgyList.forEach(
                strategy -> {
                    try {
                        Map<String, List<SearchResultDto>> results = strategy.getSearchResult();
//                        PrintUtils.showExecuteStrategy(strategy.getStrategyName());
//                        PrintUtils.printResult(results);

                        CsvUtils.generateReport();
                        CsvUtils.generateCSV(results, strategy.getStrategyName());
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
        );
        CsvUtils.combineCsvFiles(Constant.REPORT_PATH);
    }
}
