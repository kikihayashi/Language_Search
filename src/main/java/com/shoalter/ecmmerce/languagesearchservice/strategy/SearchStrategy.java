package com.shoalter.ecmmerce.languagesearchservice.strategy;

import com.shoalter.ecmmerce.languagesearchservice.dto.SearchResultDto;

import java.util.List;
import java.util.Map;

public interface SearchStrategy {
    String getStrategyName();

    Map<String, List<SearchResultDto>> getSearchResult();
}
