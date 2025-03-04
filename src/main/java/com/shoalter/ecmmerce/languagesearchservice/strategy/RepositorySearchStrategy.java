package com.shoalter.ecmmerce.languagesearchservice.strategy;

import com.shoalter.ecmmerce.languagesearchservice.constants.Constant;
import com.shoalter.ecmmerce.languagesearchservice.dto.SearchResultDto;
import com.shoalter.ecmmerce.languagesearchservice.dto.ServiceFileDto;
import com.shoalter.ecmmerce.languagesearchservice.utils.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RepositorySearchStrategy implements SearchStrategy {
    private static final String STRATEGY_NAME = "repository";

    private static final Pattern QUERY_PATTERN = Pattern.compile(
            "@Query\\(\\s*value\\s*=\\s*\"\"\"([\\s\\S]*?)\"\"\".*?\\)",
            Pattern.DOTALL);

    private static final Pattern METHOD_PATTERN = Pattern.compile(
            "(?:public|protected|private|static|final|abstract|synchronized|native)?(\\S.*?\\s+)(\\w+)\\s*\\([^)]*\\)\\s*;",
            Pattern.DOTALL);

    private static final List<Pattern> KEYWORD_PATTERNS = Arrays.asList(
            Pattern.compile("Generated.*?lp", Pattern.CASE_INSENSITIVE),
            Pattern.compile("languagePk", Pattern.CASE_INSENSITIVE),
            Pattern.compile("language", Pattern.CASE_INSENSITIVE),
            Pattern.compile("langPk", Pattern.CASE_INSENSITIVE),
            Pattern.compile("lang", Pattern.CASE_INSENSITIVE),
            Pattern.compile("lp", Pattern.CASE_INSENSITIVE)
    );

    @Override
    public String getStrategyName() {
        return STRATEGY_NAME;
    }

    @Override
    public Map<String, List<SearchResultDto>> getSearchResult() {
        try {
            List<ServiceFileDto> serviceFileDtoList = FileUtils.getServiceFileDtoList(Constant.REPOSITORY_PATHS);
            Map<String, List<SearchResultDto>> results = new HashMap<>();
            for (ServiceFileDto serviceFileDto : serviceFileDtoList) {
                List<SearchResultDto> matches = searchKeywordInJavaFile(serviceFileDto);
                if (!matches.isEmpty()) {
                    results.put(serviceFileDto.serviceName(), matches);
                }
            }
            return results;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List<SearchResultDto> searchKeywordInJavaFile(ServiceFileDto serviceFileDto) throws IOException {
        String serviceName = serviceFileDto.serviceName();
        List<File> files = serviceFileDto.files();

        List<SearchResultDto> matchingMethods = new ArrayList<>();
        for (File file : files) {
            String filePath = file.getPath();
            String content = Files.readString(file.toPath());

            Matcher queryMatcher = QUERY_PATTERN.matcher(content);
            while (queryMatcher.find()) {
                String sqlCommand = queryMatcher.group(1);

                if (containKeywords(sqlCommand)) {
                    int startIndex = queryMatcher.end(); //從@Query後的位置開始查找
                    String substring = content.substring(startIndex);
                    Matcher methodMatcher = METHOD_PATTERN.matcher(substring);

                    if (methodMatcher.find()) {
                        String methodName = filterMethodName(methodMatcher.group(0));
                        String newSqlCommand = filterSqlCommand(sqlCommand);
                        matchingMethods.add(new SearchResultDto(serviceName, filePath, methodName, newSqlCommand));
                    } else {
                        System.out.println(filePath + "：SQL語法找不到對應的方法名稱 -->" + sqlCommand);
                    }
                }
            }
        }
        return matchingMethods;
    }

    private String filterSqlCommand(String sqlCommand) {
        return sqlCommand.trim();
    }

    private String filterMethodName(String input) {
        return input.replaceAll("(?s)@.*?\\)", "")
                .replaceAll("^\\s*", "")
                .replaceAll("\\s*;$", "");
    }

    private boolean containKeywords(String queryValue) {
        for (Pattern pattern : KEYWORD_PATTERNS) {
            Matcher matcher = pattern.matcher(queryValue);
            if (matcher.find()) {
                return true;
            }
        }
        return false;
    }
}
