package com.shoalter.ecmmerce.languagesearchservice.utils;

import com.shoalter.ecmmerce.languagesearchservice.dto.ServiceFileDto;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileUtils {

    public static List<ServiceFileDto> getServiceFileDtoList(HashMap<String, List<String>> paths) throws IOException {
        try {
            List<ServiceFileDto> serviceFileDtoList = new ArrayList<>();
            for (Map.Entry<String, List<String>> entry : paths.entrySet()) {
                for (String searchPath : entry.getValue()) {
                    serviceFileDtoList.add(new ServiceFileDto(entry.getKey(), getJavaFiles(searchPath)));
                }
            }
            return serviceFileDtoList;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<File> getJavaFiles(String searchPath) throws IOException {
        return Files.list(Paths.get(searchPath))
                .filter(p -> p.toString().endsWith(".java"))
                .map(Path::toFile)
                .toList();
    }
}
