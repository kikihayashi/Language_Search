package com.shoalter.ecmmerce.languagesearchservice;

import com.shoalter.ecmmerce.languagesearchservice.service.CheckService;
import com.shoalter.ecmmerce.languagesearchservice.service.SearchService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LanguageSearchApplication {

    public static void main(String[] args) {
        runService("SearchService", SearchService::run);
        runService("CheckService", CheckService::run);
    }

    private static void runService(String serviceName, Runnable service) {
        log.info("[runService] Start running {}", serviceName);
        long startTime = System.currentTimeMillis();
        service.run();
        long endTime = System.currentTimeMillis();
        log.info("[runService] {} has finished running, spent time: {} ms", serviceName, (endTime - startTime));
    }
}
