package com.shoalter.ecmmerce.languagesearchservice;

import com.shoalter.ecmmerce.languagesearchservice.service.CheckService;
import com.shoalter.ecmmerce.languagesearchservice.service.SearchService;

public class LanguageSearchApplication {

    public static void main(String[] args) {
        runService("SearchService", SearchService::run);
        runService("CheckService", CheckService::run);
    }

    private static void runService(String serviceName, Runnable service) {
        System.out.println("Start running " + serviceName);
        long startTime = System.currentTimeMillis();
        service.run();
        long endTime = System.currentTimeMillis();
        System.out.printf("%s has finished running, spent time: %d ms%n%n", serviceName, (endTime - startTime));
    }
}
