package com.shoalter.ecmmerce.languagesearchservice.strategy;

import com.shoalter.ecmmerce.languagesearchservice.constants.Constant;
import com.shoalter.ecmmerce.languagesearchservice.dto.SearchResultDto;
import com.shoalter.ecmmerce.languagesearchservice.dto.ServiceFileDto;
import com.shoalter.ecmmerce.languagesearchservice.utils.FileUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class I18nSearchStrategy implements SearchStrategy {
    private static final String STRATEGY_NAME = "i18n";

    // 定義需要搜尋的關鍵字
    private static final List<Pattern> KEYWORD_PATTERNS = List.of(
            Pattern.compile("LanguageEnum", Pattern.CASE_INSENSITIVE),
            Pattern.compile("Locale", Pattern.CASE_INSENSITIVE),
            Pattern.compile("\"en\"", Pattern.CASE_INSENSITIVE),
            Pattern.compile("\"zh\"", Pattern.CASE_INSENSITIVE),
            Pattern.compile("\"EN\"", Pattern.CASE_INSENSITIVE),
            Pattern.compile("\"ZH\"", Pattern.CASE_INSENSITIVE),
            Pattern.compile("languagePk", Pattern.CASE_INSENSITIVE),
            Pattern.compile("Language", Pattern.CASE_INSENSITIVE),
            Pattern.compile("LangPk", Pattern.CASE_INSENSITIVE),
            Pattern.compile("langPk", Pattern.CASE_INSENSITIVE),
            Pattern.compile("lang", Pattern.CASE_INSENSITIVE)
    );

    // 匹配class方法的正則表達式 (包括返回類型、方法名稱及參數列表)
    private static final Pattern CLASS_METHOD_PATTERN = Pattern.compile(
            "(?:public|protected|private|static|final|abstract|native)?\\s+" +
                    "(?!synchronized\\b)" +
                    "[\\w<>\\[\\],.\\s]+\\s+" + // 回傳型別（可能有泛型）
                    "\\b(?!if\\b|for\\b|while\\b|switch\\b|catch\\b|try\\b|synchronized\\b)" + // 排除非方法簽名的關鍵字
                    "\\w+\\s*\\([^)]*\\)\\s*" + // 方法名稱和參數列表
                    "(?:throws\\s+[\\w\\s,]+)?\\s*\\{",
            Pattern.DOTALL
    );

    // 匹配interface方法的正則表達式 (包括返回類型、方法名稱及參數列表)
    private static final Pattern INTERFACE_METHOD_PATTERN = Pattern.compile(
            "(?:public|protected|private|static|final|abstract|synchronized|native)?\\s*" +
                    "(?:[\\w<>,\\s\\[\\]]+\\s+)+" +
                    "\\b(?!if\\b|for\\b|while\\b|switch\\b|catch\\b|try\\b|synchronized\\b)" + // 排除非方法簽名的關鍵字
                    "(\\w+\\s*\\([^)]*\\))\\s*" +
                    "(?:throws\\s+[\\w\\s,]+)?",
            Pattern.DOTALL
    );

    private static final List<String> SPECIAL_KEYWORDS = List.of(
            "new"
    );

    @Override
    public String getStrategyName() {
        return STRATEGY_NAME;
    }

    @Override
    public Map<String, List<SearchResultDto>> getSearchResult() {
        try {
            List<ServiceFileDto> serviceFileDtoList = FileUtils.getServiceFileDtoList(Constant.I18N_PATHS);
            Map<String, List<SearchResultDto>> results = new HashMap<>();
            for (ServiceFileDto serviceFileDto : serviceFileDtoList) {
                List<SearchResultDto> matches = searchKeywordInJavaFile(serviceFileDto);
                if (!matches.isEmpty()) {
                    List<SearchResultDto> searchResultDtos = results.getOrDefault(serviceFileDto.serviceName(), new ArrayList<>());
                    searchResultDtos.addAll(matches);
                    results.put(serviceFileDto.serviceName(), searchResultDtos);
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
            List<String> codeLines = getCodeLines(file);
            String oneLineCode = getOneLineCode(codeLines);
            Set<String> methodSignatures = extractMethodSignatures(oneLineCode);
            Map<String, String> methodsWithKeywords = analyzeMethodsForKeywords(methodSignatures, codeLines);

            for (Map.Entry<String, String> entry : methodsWithKeywords.entrySet()) {
                matchingMethods.add(new SearchResultDto(serviceName, file.getAbsolutePath(), entry.getKey(), entry.getValue()));
            }
        }
        return matchingMethods;
    }

    private Set<String> filterMethodSignatures(Set<String> methodSignatures) {
        Set<String> finalMethodSignatures = new HashSet<>();
        for (String methodSignature : methodSignatures) {
            String methodTypeAndName = methodSignature.split("\\(")[0];
            String[] split = methodTypeAndName.split(" ");
            String s = split[split.length - 2];
            if (!SPECIAL_KEYWORDS.contains(s)) {
                finalMethodSignatures.add(methodSignature);
            }
        }
        return finalMethodSignatures;
    }

    private List<String> getCodeLines(File javaFile) throws IOException {
        List<String> codeLines = new ArrayList<>();

        // 讀取檔案內容
        try (BufferedReader reader = new BufferedReader(new FileReader(javaFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                codeLines.add(line.trim());
            }
        }
        return codeLines;
    }

    private String getOneLineCode(List<String> codeLines) {
        // 合併成單行，方便正則分析
        StringBuilder codeBuilder = new StringBuilder();
        for (String line : codeLines) {
            codeBuilder.append(line).append(" ");
        }

        return codeBuilder.toString();
    }

    public Set<String> extractMethodSignatures(String oneLineCode) {
        Set<String> methodSignatures = new HashSet<>();

        Matcher matcher = getMatcher(oneLineCode);
        while (matcher.find()) {
            String group = matcher.group();
            String rawSignature = group.trim();
            methodSignatures.add(rawSignature);
        }
        return filterMethodSignatures(methodSignatures);
    }

    private Matcher getMatcher(String oneLineCode) {
        if (oneLineCode.contains("public interface") &&
                !oneLineCode.contains("public class") &&
                !oneLineCode.contains("@Query")) {
            return INTERFACE_METHOD_PATTERN.matcher(oneLineCode);
        }
        return CLASS_METHOD_PATTERN.matcher(oneLineCode);
    }

    private Map<String, String> analyzeMethodsForKeywords(Set<String> methodSignatures, List<String> codeLines) {
        Map<String, String> methodKeywordPairs = new HashMap<>();
        String currentMethod = "";
        boolean inMethod = false;

        for (int row = 0; row < codeLines.size(); row++) {
            String currentLine = codeLines.get(row).trim();
            if (isDefinitelyNotMethod(currentLine)) {
                continue;
            }

            if (inMethod) {
                boolean isFindKeyword = false;
                while (row < codeLines.size() - 1) {
                    currentLine = codeLines.get(row).trim();

                    if (isDefinitelyNotMethod(currentLine)) {
                        row++;
                        continue;
                    }

                    if (!isFindKeyword) {
                        isFindKeyword = findKeywordAndSet(methodKeywordPairs, currentLine, currentMethod);
                    }

                    String methodSignature = getMethodSignatureOfCurrentLine(methodSignatures, currentLine, codeLines, row);
                    String tempCurrentMethod = convertToMethod(methodSignature);
                    if (!methodSignature.isEmpty() && !tempCurrentMethod.equals(currentMethod)) {
                        row--;
                        break;
                    }
                    row++;
                }
                inMethod = false;
            } else {
                String methodSignature = getMethodSignatureOfCurrentLine(methodSignatures, currentLine, codeLines, row);
                if (!methodSignature.isEmpty()) {
                    currentMethod = convertToMethod(methodSignature);
                    inMethod = true;
                }
            }
        }
        return methodKeywordPairs;
    }

    private static boolean findKeywordAndSet(Map<String, String> methodKeywordPairs, String line, String currentMethod) {
        for (Pattern keywordPattern : KEYWORD_PATTERNS) {
            Matcher matcher = keywordPattern.matcher(line);
            if (matcher.find()) {
                methodKeywordPairs.put(currentMethod, matcher.group());
                return true;
            }
        }
        return false;
    }

    private static boolean isDefinitelyNotMethod(String line) {
        return line.isEmpty() ||
                line.startsWith("//") ||
                line.startsWith("package") ||
                line.startsWith("import") ||
                line.startsWith("public class") ||
                line.startsWith("public interface") ||
                line.startsWith("private final") ||
                line.startsWith("@Slf4j") ||
                line.startsWith("@RestController") ||
                line.startsWith("@RequestMapping") ||
                line.startsWith("@RequiredArgsConstructor") ||
                line.startsWith("@Service") ||
                line.startsWith("@Repository") ||
                line.startsWith("@Autowired") ||
                line.contains("@Cacheable") ||
                line.contains("cacheNames = ") ||
                line.contains("cacheManager = ");
    }

    private static String getMethodSignatureOfCurrentLine(Set<String> methodSignatures, String line, List<String> codeLines, int row) {
        for (String signature : methodSignatures) {
            if (signature.contains(line)) {
                if (signature.equals(line)) {
                    return signature;
                }

                int index = row;
                String probablyMethod = line;
                while (!probablyMethod.contains("{") && index < codeLines.size() - 1) {
                    String nextLine = codeLines.get(++index);
                    probablyMethod = String.format("%s%s", probablyMethod, nextLine);
                }

                String signatureWithoutSpace = signature.replaceAll("\\s+", "");
                String probabilityMethodWithoutSpace = probablyMethod.replaceAll("\\s+", "");

                if (signatureWithoutSpace.equals(probabilityMethodWithoutSpace)) {
                    return signature;
                }
            }
        }
        return "";
    }

    private static String convertToMethod(String methodSignature) {
        return methodSignature
                .replaceFirst("Transactional", "")
                .replaceFirst("i18n Config", "")
                .replaceAll("\\b(Override|public|protected|private|static|final|abstract|synchronized|native [\\w\\s,]+)\\b", "")
                .replaceAll("\\s*\\{", "") // 移除開頭大括號
                .replaceAll("\\s+", " ") // 多餘空白壓縮為單一空白
                .trim()
                .split("throws")[0];
    }
}

