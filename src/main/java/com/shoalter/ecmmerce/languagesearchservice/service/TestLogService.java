package com.shoalter.ecmmerce.languagesearchservice.service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestLogService {
    public static void main(String[] args) {
        log.trace("[trace] stack:[{}]", "1");
        log.debug("[debug] stack:[{}]", "2");
        log.info("[info] stack:[{}]", "3");
        log.warn("[warn] stack:[{}]", "4");
        log.error("[error] stack:[{}]", "5");
    }
}
