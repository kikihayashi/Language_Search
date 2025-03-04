package com.shoalter.ecmmerce.languagesearchservice.constants;

import java.util.HashMap;
import java.util.List;

public class Constant {

    public static final String REPORT_PATH = "C:\\work\\Language_Search\\report";

    private static final String ADDRESS = "address";
    private static final String CART = "cart";
    private static final String IIMS = "iims";
    private static final String NOTIFICATION = "notification";
    private static final String ORDER = "order";
    private static final String PRODUCT = "product";
    private static final String USER = "user";
    private static final String PROMOTION = "promotion";
    private static final String CACHING_MANAGEMENT = "caching-management";
    private static final String CONFIG_SERVER = "config-server";
    private static final String PAGE_COMPONENT = "page-component";
    private static final String THIRD_PARTY = "third-party";
    private static final String INTERNAL = "internal-api";
    private static final String LOGIN = "login";
    private static final String MOBILE = "mobile-api";
    private static final String TEST_CASE = "test-case";

    public static final HashMap<String, List<String>> REPOSITORY_PATHS = new HashMap<>() {{
//        put(ADDRESS, List.of(
//                "C:\\work\\shoalter-ecommerce-business\\shoalter-ecommerce-business-address-service\\src\\main\\java\\com\\shoalter\\ecommerce\\addressservice\\dao",
//                "C:\\work\\shoalter-ecommerce-business\\shoalter-ecommerce-business-address-service\\src\\main\\java\\com\\shoalter\\ecommerce\\addressservice\\dao\\gensrc"
//        ));
//
//        put(CART, List.of(
//                "C:\\work\\shoalter-ecommerce-business\\shoalter-ecommerce-business-cart-service\\src\\main\\java\\com\\shoalter\\ecommerce\\cartservice\\dao",
//                "C:\\work\\shoalter-ecommerce-business\\shoalter-ecommerce-business-cart-service\\src\\main\\java\\com\\shoalter\\ecommerce\\cartservice\\dao\\gensrc"
//        ));
//
//        put(IIMS, List.of(
//                "C:\\work\\shoalter-ecommerce-business\\shoalter-ecommerce-business-hktv-iims\\src\\main\\java\\com\\shoalter\\ecommence\\inventorymanagementsystem\\dao"
//        ));
//
//        put(NOTIFICATION, List.of(
//                "C:\\work\\shoalter-ecommerce-business\\shoalter-ecommerce-business-notification-service\\src\\main\\java\\com\\shoalter\\ecommerce\\notification\\dao",
//                "C:\\work\\shoalter-ecommerce-business\\shoalter-ecommerce-business-notification-service\\src\\main\\java\\com\\shoalter\\ecommerce\\notification\\dao\\gensrc"
//        ));
//
//        put(ORDER, List.of(
//                "C:\\work\\shoalter-ecommerce-business\\shoalter-ecommerce-business-order-service\\src\\main\\java\\com\\shoalter\\ecommerce\\orderservice\\dao",
//                "C:\\work\\shoalter-ecommerce-business\\shoalter-ecommerce-business-order-service\\src\\main\\java\\com\\shoalter\\ecommerce\\orderservice\\dao\\gensrc"
//        ));
//
//        put(PRODUCT, List.of(
//                "C:\\work\\shoalter-ecommerce-business\\shoalter-ecommerce-business-product-service\\src\\main\\java\\com\\shoalter\\ecommerce\\productservice\\dao",
//                "C:\\work\\shoalter-ecommerce-business\\shoalter-ecommerce-business-product-service\\src\\main\\java\\com\\shoalter\\ecommerce\\productservice\\dao\\gensrc"
//        ));
//
//        put(PROMOTION, List.of(
//                "C:\\work\\shoalter-ecommerce-business\\shoalter-ecommerce-business-promotion-service\\src\\main\\java\\com\\shoalter\\ecommerce\\promotionservice\\dao",
//                "C:\\work\\shoalter-ecommerce-business\\shoalter-ecommerce-business-promotion-service\\src\\main\\java\\com\\shoalter\\ecommerce\\promotionservice\\dao\\gensrc"
//        ));
//
//        put(USER, List.of(
//                "C:\\work\\shoalter-ecommerce-business\\shoalter-ecommerce-business-user-service\\src\\main\\java\\com\\shoalter\\ecommerce\\business\\userservice\\dao",
//                "C:\\work\\shoalter-ecommerce-business\\shoalter-ecommerce-business-user-service\\src\\main\\java\\com\\shoalter\\ecommerce\\business\\userservice\\dao\\gensrc"
//        ));
//
//        put(CONFIG_SERVER, List.of(
//                "C:\\work\\shoalter-ecommerce-infra-master-repo\\shoalter-config-server\\configServer\\src\\main\\java\\com\\shoalter\\ecommence\\shoalterconfigserver\\dao",
//                "C:\\work\\shoalter-ecommerce-infra-master-repo\\shoalter-config-server\\configServer\\src\\main\\java\\com\\shoalter\\ecommence\\shoalterconfigserver\\dao\\gensrc"
//        ));
//
//        put(PAGE_COMPONENT, List.of(
//                "C:\\work\\shoalter-ecommerce-infra-master-repo\\shoalter-ecommerce-page-component-service\\src\\main\\java\\com\\shoalter\\ecommerce\\pagecomponentservice\\dao",
//                "C:\\work\\shoalter-ecommerce-infra-master-repo\\shoalter-ecommerce-page-component-service\\src\\main\\java\\com\\shoalter\\ecommerce\\pagecomponentservice\\dao\\gensrc"
//        ));
//
//        put(INTERNAL, List.of(
//                "C:\\work\\shoalter-ecommerce-infra-master-repo\\shoalter-infra-internal-api-gateway\\src\\main\\java\\com\\shoalter\\ecommerce\\internalgateway\\repository"
//        ));
//
//        put(LOGIN, List.of(
//                "C:\\work\\shoalter-ecommerce-infra-master-repo\\shoalter-infra-login-service\\src\\main\\java\\hk\\com\\hktv\\hktvcustomerservice\\hybris\\repository"
//        ));
//
//        put(MOBILE, List.of(
//                "C:\\work\\shoalter-ecommerce-infra-master-repo\\shoalter-infra-mobile-api-gateway\\src\\main\\java\\com\\shoalter\\ecommerce\\mobilegateway\\repository"
//        ));
    }};

    public static final HashMap<String, List<String>> I18N_PATHS = new HashMap<>() {{
        put(TEST_CASE, List.of(
                "C:\\work\\Language_Search\\testcase"
        ));

//        put(ADDRESS, List.of(
//                "C:\\work\\shoalter-ecommerce-business\\shoalter-ecommerce-business-address-service\\src\\main\\java\\com\\shoalter\\ecommerce\\addressservice\\client\\grpc\\impl",
//                "C:\\work\\shoalter-ecommerce-business\\shoalter-ecommerce-business-address-service\\src\\main\\java\\com\\shoalter\\ecommerce\\addressservice\\client\\impl",
//                "C:\\work\\shoalter-ecommerce-business\\shoalter-ecommerce-business-address-service\\src\\main\\java\\com\\shoalter\\ecommerce\\addressservice\\dao\\impl",
//                "C:\\work\\shoalter-ecommerce-business\\shoalter-ecommerce-business-address-service\\src\\main\\java\\com\\shoalter\\ecommerce\\addressservice\\service\\impl\\grpc",
//                "C:\\work\\shoalter-ecommerce-business\\shoalter-ecommerce-business-address-service\\src\\main\\java\\com\\shoalter\\ecommerce\\addressservice\\service\\impl",
//                "C:\\work\\shoalter-ecommerce-business\\shoalter-ecommerce-business-address-service\\src\\main\\java\\com\\shoalter\\ecommerce\\addressservice\\populator",
//                "C:\\work\\shoalter-ecommerce-business\\shoalter-ecommerce-business-address-service\\src\\main\\java\\com\\shoalter\\ecommerce\\addressservice\\utils",
//                "C:\\work\\shoalter-ecommerce-business\\shoalter-ecommerce-business-address-service\\src\\main\\java\\com\\shoalter\\ecommerce\\addressservice\\config"
//
////                "C:\\work\\shoalter-ecommerce-business\\shoalter-ecommerce-business-address-service\\src\\main\\java\\com\\shoalter\\ecommerce\\addressservice\\converter",
//        ));
//
//        put(CART, List.of(
//                "C:\\work\\shoalter-ecommerce-business\\shoalter-ecommerce-business-cart-service\\src\\main\\java\\com\\shoalter\\ecommerce\\cartservice\\client\\grpc\\impl",
//                "C:\\work\\shoalter-ecommerce-business\\shoalter-ecommerce-business-cart-service\\src\\main\\java\\com\\shoalter\\ecommerce\\cartservice\\client\\impl",
//                "C:\\work\\shoalter-ecommerce-business\\shoalter-ecommerce-business-cart-service\\src\\main\\java\\com\\shoalter\\ecommerce\\cartservice\\dao",
//                "C:\\work\\shoalter-ecommerce-business\\shoalter-ecommerce-business-cart-service\\src\\main\\java\\com\\shoalter\\ecommerce\\cartservice\\grpc",
//                "C:\\work\\shoalter-ecommerce-business\\shoalter-ecommerce-business-cart-service\\src\\main\\java\\com\\shoalter\\ecommerce\\cartservice\\populator",
//                "C:\\work\\shoalter-ecommerce-business\\shoalter-ecommerce-business-cart-service\\src\\main\\java\\com\\shoalter\\ecommerce\\cartservice\\service\\impl",
//                "C:\\work\\shoalter-ecommerce-business\\shoalter-ecommerce-business-cart-service\\src\\main\\java\\com\\shoalter\\ecommerce\\cartservice\\utils"
//
////                "C:\\work\\shoalter-ecommerce-business\\shoalter-ecommerce-business-cart-service\\src\\main\\java\\com\\shoalter\\ecommerce\\cartservice\\factory",
////                "C:\\work\\shoalter-ecommerce-business\\shoalter-ecommerce-business-cart-service\\src\\main\\java\\com\\shoalter\\ecommerce\\cartservice\\helper",
////                "C:\\work\\shoalter-ecommerce-business\\shoalter-ecommerce-business-cart-service\\src\\main\\java\\com\\shoalter\\ecommerce\\cartservice\\pk",
////                "C:\\work\\shoalter-ecommerce-business\\shoalter-ecommerce-business-cart-service\\src\\main\\java\\com\\shoalter\\ecommerce\\cartservice\\serializer",
//        ));
//
//        put(NOTIFICATION, List.of(
//                "C:\\work\\shoalter-ecommerce-business\\shoalter-ecommerce-business-notification-service\\src\\main\\java\\com\\shoalter\\ecommerce\\notification\\client\\grpc\\impl",
//                "C:\\work\\shoalter-ecommerce-business\\shoalter-ecommerce-business-notification-service\\src\\main\\java\\com\\shoalter\\ecommerce\\notification\\client\\impl",
//                "C:\\work\\shoalter-ecommerce-business\\shoalter-ecommerce-business-notification-service\\src\\main\\java\\com\\shoalter\\ecommerce\\notification\\config",
//                "C:\\work\\shoalter-ecommerce-business\\shoalter-ecommerce-business-notification-service\\src\\main\\java\\com\\shoalter\\ecommerce\\notification\\service\\grpc",
//                "C:\\work\\shoalter-ecommerce-business\\shoalter-ecommerce-business-notification-service\\src\\main\\java\\com\\shoalter\\ecommerce\\notification\\service\\impl",
//                "C:\\work\\shoalter-ecommerce-business\\shoalter-ecommerce-business-notification-service\\src\\main\\java\\com\\shoalter\\ecommerce\\notification\\utils"
//        ));
//
//        put(ORDER, List.of(
//                "C:\\work\\shoalter-ecommerce-business\\shoalter-ecommerce-business-order-service\\src\\main\\java\\com\\shoalter\\ecommerce\\orderservice\\client\\grpc\\impl",
//                "C:\\work\\shoalter-ecommerce-business\\shoalter-ecommerce-business-order-service\\src\\main\\java\\com\\shoalter\\ecommerce\\orderservice\\client\\impl",
//                "C:\\work\\shoalter-ecommerce-business\\shoalter-ecommerce-business-order-service\\src\\main\\java\\com\\shoalter\\ecommerce\\orderservice\\dao",
//                "C:\\work\\shoalter-ecommerce-business\\shoalter-ecommerce-business-order-service\\src\\main\\java\\com\\shoalter\\ecommerce\\orderservice\\service\\impl",
//                "C:\\work\\shoalter-ecommerce-business\\shoalter-ecommerce-business-order-service\\src\\main\\java\\com\\shoalter\\ecommerce\\orderservice\\service\\impl\\grpc",
//                "C:\\work\\shoalter-ecommerce-business\\shoalter-ecommerce-business-order-service\\src\\main\\java\\com\\shoalter\\ecommerce\\orderservice\\utils"
//
////                "C:\\work\\shoalter-ecommerce-business\\shoalter-ecommerce-business-order-service\\src\\main\\java\\com\\shoalter\\ecommerce\\orderservice\\comparator",
////                "C:\\work\\shoalter-ecommerce-business\\shoalter-ecommerce-business-order-service\\src\\main\\java\\com\\shoalter\\ecommerce\\orderservice\\helper",
////                "C:\\work\\shoalter-ecommerce-business\\shoalter-ecommerce-business-order-service\\src\\main\\java\\com\\shoalter\\ecommerce\\orderservice\\pk",
////                "C:\\work\\shoalter-ecommerce-business\\shoalter-ecommerce-business-order-service\\src\\main\\java\\com\\shoalter\\ecommerce\\orderservice\\serializer",
//        ));
//
//        put(PRODUCT, List.of(
//                "C:\\work\\shoalter-ecommerce-business\\shoalter-ecommerce-business-product-service\\src\\main\\java\\com\\shoalter\\ecommerce\\productservice\\client\\grpc\\impl",
//                "C:\\work\\shoalter-ecommerce-business\\shoalter-ecommerce-business-product-service\\src\\main\\java\\com\\shoalter\\ecommerce\\productservice\\client\\impl",
//                "C:\\work\\shoalter-ecommerce-business\\shoalter-ecommerce-business-product-service\\src\\main\\java\\com\\shoalter\\ecommerce\\productservice\\dao",
//                "C:\\work\\shoalter-ecommerce-business\\shoalter-ecommerce-business-product-service\\src\\main\\java\\com\\shoalter\\ecommerce\\productservice\\facade",
//                "C:\\work\\shoalter-ecommerce-business\\shoalter-ecommerce-business-product-service\\src\\main\\java\\com\\shoalter\\ecommerce\\productservice\\grpc",
//                "C:\\work\\shoalter-ecommerce-business\\shoalter-ecommerce-business-product-service\\src\\main\\java\\com\\shoalter\\ecommerce\\productservice\\populator",
//                "C:\\work\\shoalter-ecommerce-business\\shoalter-ecommerce-business-product-service\\src\\main\\java\\com\\shoalter\\ecommerce\\productservice\\service\\impl",
//                "C:\\work\\shoalter-ecommerce-business\\shoalter-ecommerce-business-product-service\\src\\main\\java\\com\\shoalter\\ecommerce\\productservice\\utils"
//
////                "C:\\work\\shoalter-ecommerce-business\\shoalter-ecommerce-business-product-service\\src\\main\\java\\com\\shoalter\\ecommerce\\productservice\\converter",
//        ));
//
//        put(PROMOTION, List.of(
//                "C:\\work\\shoalter-ecommerce-business\\shoalter-ecommerce-business-promotion-service\\src\\main\\java\\com\\shoalter\\ecommerce\\promotionservice\\client\\grpc\\impl",
//                "C:\\work\\shoalter-ecommerce-business\\shoalter-ecommerce-business-promotion-service\\src\\main\\java\\com\\shoalter\\ecommerce\\promotionservice\\client\\impl",
//                "C:\\work\\shoalter-ecommerce-business\\shoalter-ecommerce-business-promotion-service\\src\\main\\java\\com\\shoalter\\ecommerce\\promotionservice\\domain\\promotion\\rule",
//                "C:\\work\\shoalter-ecommerce-business\\shoalter-ecommerce-business-promotion-service\\src\\main\\java\\com\\shoalter\\ecommerce\\promotionservice\\facade",
//                "C:\\work\\shoalter-ecommerce-business\\shoalter-ecommerce-business-promotion-service\\src\\main\\java\\com\\shoalter\\ecommerce\\promotionservice\\grpc",
//                "C:\\work\\shoalter-ecommerce-business\\shoalter-ecommerce-business-promotion-service\\src\\main\\java\\com\\shoalter\\ecommerce\\promotionservice\\populator",
//                "C:\\work\\shoalter-ecommerce-business\\shoalter-ecommerce-business-promotion-service\\src\\main\\java\\com\\shoalter\\ecommerce\\promotionservice\\service\\impl",
//                "C:\\work\\shoalter-ecommerce-business\\shoalter-ecommerce-business-promotion-service\\src\\main\\java\\com\\shoalter\\ecommerce\\promotionservice\\utils"
//
////                "C:\\work\\shoalter-ecommerce-business\\shoalter-ecommerce-business-promotion-service\\src\\main\\java\\com\\shoalter\\ecommerce\\promotionservice\\converter",
////                "C:\\work\\shoalter-ecommerce-business\\shoalter-ecommerce-business-promotion-service\\src\\main\\java\\com\\shoalter\\ecommerce\\promotionservice\\domain\\promotion\\action",
////                "C:\\work\\shoalter-ecommerce-business\\shoalter-ecommerce-business-promotion-service\\src\\main\\java\\com\\shoalter\\ecommerce\\promotionservice\\domain\\promotion\\restriction",
////                "C:\\work\\shoalter-ecommerce-business\\shoalter-ecommerce-business-promotion-service\\src\\main\\java\\com\\shoalter\\ecommerce\\promotionservice\\domain\\voucher\\restriction",
////                "C:\\work\\shoalter-ecommerce-business\\shoalter-ecommerce-business-promotion-service\\src\\main\\java\\com\\shoalter\\ecommerce\\promotionservice\\mq",
//        ));
//
//        put(USER, List.of(
//                "C:\\work\\shoalter-ecommerce-business\\shoalter-ecommerce-business-user-service\\src\\main\\java\\com\\shoalter\\ecommerce\\business\\userservice\\client\\impl",
//                "C:\\work\\shoalter-ecommerce-business\\shoalter-ecommerce-business-user-service\\src\\main\\java\\com\\shoalter\\ecommerce\\business\\userservice\\grpc\\impl",
//                "C:\\work\\shoalter-ecommerce-business\\shoalter-ecommerce-business-user-service\\src\\main\\java\\com\\shoalter\\ecommerce\\business\\userservice\\grpc",
//                "C:\\work\\shoalter-ecommerce-business\\shoalter-ecommerce-business-user-service\\src\\main\\java\\com\\shoalter\\ecommerce\\business\\userservice\\service\\impl",
//                "C:\\work\\shoalter-ecommerce-business\\shoalter-ecommerce-business-user-service\\src\\main\\java\\com\\shoalter\\ecommerce\\business\\userservice\\util"
//
////                "C:\\work\\shoalter-ecommerce-business\\shoalter-ecommerce-business-user-service\\src\\main\\java\\com\\shoalter\\ecommerce\\business\\userservice\\helper",
////                "C:\\work\\shoalter-ecommerce-business\\shoalter-ecommerce-business-user-service\\src\\main\\java\\com\\shoalter\\ecommerce\\business\\userservice\\mq",
////                "C:\\work\\shoalter-ecommerce-business\\shoalter-ecommerce-business-user-service\\src\\main\\java\\com\\shoalter\\ecommerce\\business\\userservice\\pk",
////                "C:\\work\\shoalter-ecommerce-business\\shoalter-ecommerce-business-user-service\\src\\main\\java\\com\\shoalter\\ecommerce\\business\\userservice\\validator",
//        ));
//
//        put(CACHING_MANAGEMENT, List.of(
//                "C:\\work\\shoalter-ecommerce-infra-master-repo\\shoalter-caching-management-server\\src\\main\\java\\com\\shoalter\\ecommerce\\cachingmanagement\\client\\impl",
//                "C:\\work\\shoalter-ecommerce-infra-master-repo\\shoalter-caching-management-server\\src\\main\\java\\com\\shoalter\\ecommerce\\cachingmanagement\\service",
//                "C:\\work\\shoalter-ecommerce-infra-master-repo\\shoalter-caching-management-server\\src\\main\\java\\com\\shoalter\\ecommerce\\cachingmanagement\\utils"
//
////                "C:\\work\\shoalter-ecommerce-infra-master-repo\\shoalter-caching-management-server\\src\\main\\java\\com\\shoalter\\ecommerce\\cachingmanagement\\mq",
//        ));
//        put(CONFIG_SERVER, List.of(
//                "C:\\work\\shoalter-ecommerce-infra-master-repo\\shoalter-config-server\\configServer\\src\\main\\java\\com\\shoalter\\ecommence\\shoalterconfigserver\\client\\impl",
//                "C:\\work\\shoalter-ecommerce-infra-master-repo\\shoalter-config-server\\configServer\\src\\main\\java\\com\\shoalter\\ecommence\\shoalterconfigserver\\grpc",
//                "C:\\work\\shoalter-ecommerce-infra-master-repo\\shoalter-config-server\\configServer\\src\\main\\java\\com\\shoalter\\ecommence\\shoalterconfigserver\\service",
//                "C:\\work\\shoalter-ecommerce-infra-master-repo\\shoalter-config-server\\configServer\\src\\main\\java\\com\\shoalter\\ecommence\\shoalterconfigserver\\service\\impl",
//                "C:\\work\\shoalter-ecommerce-infra-master-repo\\shoalter-config-server\\configServer\\src\\main\\java\\com\\shoalter\\ecommence\\shoalterconfigserver\\utils"
//
////                "C:\\work\\shoalter-ecommerce-infra-master-repo\\shoalter-config-server\\configServer\\src\\main\\java\\com\\shoalter\\ecommence\\shoalterconfigserver\\auth",
////                "C:\\work\\shoalter-ecommerce-infra-master-repo\\shoalter-config-server\\configServer\\src\\main\\java\\com\\shoalter\\ecommence\\shoalterconfigserver\\pk",
//        ));
//
//        put(THIRD_PARTY, List.of(
//                "C:\\work\\shoalter-ecommerce-infra-master-repo\\shoalter-ecommerce-infra-third-party-api-service\\src\\main\\java\\com\\shoalter\\ecommerce\\infra\\thirdpartyapiservice\\client\\impl",
//                "C:\\work\\shoalter-ecommerce-infra-master-repo\\shoalter-ecommerce-infra-third-party-api-service\\src\\main\\java\\com\\shoalter\\ecommerce\\infra\\thirdpartyapiservice\\service\\impl"
//        ));
//
//        put(PAGE_COMPONENT, List.of(
//                "C:\\work\\shoalter-ecommerce-infra-master-repo\\shoalter-ecommerce-page-component-service\\src\\main\\java\\com\\shoalter\\ecommerce\\pagecomponentservice\\client\\impl",
//                "C:\\work\\shoalter-ecommerce-infra-master-repo\\shoalter-ecommerce-page-component-service\\src\\main\\java\\com\\shoalter\\ecommerce\\pagecomponentservice\\component\\Impl",
//                "C:\\work\\shoalter-ecommerce-infra-master-repo\\shoalter-ecommerce-page-component-service\\src\\main\\java\\com\\shoalter\\ecommerce\\pagecomponentservice\\grpc",
//                "C:\\work\\shoalter-ecommerce-infra-master-repo\\shoalter-ecommerce-page-component-service\\src\\main\\java\\com\\shoalter\\ecommerce\\pagecomponentservice\\pagecomponentmanagement\\service\\impl",
//                "C:\\work\\shoalter-ecommerce-infra-master-repo\\shoalter-ecommerce-page-component-service\\src\\main\\java\\com\\shoalter\\ecommerce\\pagecomponentservice\\pagecomponentmanagement\\service\\impl\\promotion",
//                "C:\\work\\shoalter-ecommerce-infra-master-repo\\shoalter-ecommerce-page-component-service\\src\\main\\java\\com\\shoalter\\ecommerce\\pagecomponentservice\\pagecomponentmanagement\\utils",
//                "C:\\work\\shoalter-ecommerce-infra-master-repo\\shoalter-ecommerce-page-component-service\\src\\main\\java\\com\\shoalter\\ecommerce\\pagecomponentservice\\populator",
//                "C:\\work\\shoalter-ecommerce-infra-master-repo\\shoalter-ecommerce-page-component-service\\src\\main\\java\\com\\shoalter\\ecommerce\\pagecomponentservice\\service\\impl",
//                "C:\\work\\shoalter-ecommerce-infra-master-repo\\shoalter-ecommerce-page-component-service\\src\\main\\java\\com\\shoalter\\ecommerce\\pagecomponentservice\\service",
//                "C:\\work\\shoalter-ecommerce-infra-master-repo\\shoalter-ecommerce-page-component-service\\src\\main\\java\\com\\shoalter\\ecommerce\\pagecomponentservice\\strategy\\metatag\\impl",
//                "C:\\work\\shoalter-ecommerce-infra-master-repo\\shoalter-ecommerce-page-component-service\\src\\main\\java\\com\\shoalter\\ecommerce\\pagecomponentservice\\strategy\\others\\impl",
//                "C:\\work\\shoalter-ecommerce-infra-master-repo\\shoalter-ecommerce-page-component-service\\src\\main\\java\\com\\shoalter\\ecommerce\\pagecomponentservice\\utils"
//
////                "C:\\work\\shoalter-ecommerce-infra-master-repo\\shoalter-ecommerce-page-component-service\\src\\main\\java\\com\\shoalter\\ecommerce\\pagecomponentservice\\converter",
////                "C:\\work\\shoalter-ecommerce-infra-master-repo\\shoalter-ecommerce-page-component-service\\src\\main\\java\\com\\shoalter\\ecommerce\\pagecomponentservice\\pk",
//        ));

        /**
         * 以下無須查詢
         * */
//        put(IIMS, List.of(
//                "C:\\work\\shoalter-ecommerce-business\\shoalter-ecommerce-business-hktv-iims\\src\\main\\java\\com\\shoalter\\ecommence\\inventorymanagementsystem\\client\\grpc\\impl",
//                "C:\\work\\shoalter-ecommerce-business\\shoalter-ecommerce-business-hktv-iims\\src\\main\\java\\com\\shoalter\\ecommence\\inventorymanagementsystem\\client\\impl",
//                "C:\\work\\shoalter-ecommerce-business\\shoalter-ecommerce-business-hktv-iims\\src\\main\\java\\com\\shoalter\\ecommence\\inventorymanagementsystem\\config",
//                "C:\\work\\shoalter-ecommerce-business\\shoalter-ecommerce-business-hktv-iims\\src\\main\\java\\com\\shoalter\\ecommence\\inventorymanagementsystem\\dao\\impl",
//                "C:\\work\\shoalter-ecommerce-business\\shoalter-ecommerce-business-hktv-iims\\src\\main\\java\\com\\shoalter\\ecommence\\inventorymanagementsystem\\service\\impl",
//                "C:\\work\\shoalter-ecommerce-business\\shoalter-ecommerce-business-hktv-iims\\src\\main\\java\\com\\shoalter\\ecommence\\inventorymanagementsystem\\service\\impl\\grpc",
//                "C:\\work\\shoalter-ecommerce-business\\shoalter-ecommerce-business-hktv-iims\\src\\main\\java\\com\\shoalter\\ecommence\\inventorymanagementsystem\\utils",
//                "C:\\work\\shoalter-ecommerce-business\\shoalter-ecommerce-business-hktv-iims\\src\\main\\java\\com\\shoalter\\ecommence\\inventorymanagementsystem\\aop",
//                "C:\\work\\shoalter-ecommerce-business\\shoalter-ecommerce-business-hktv-iims\\src\\main\\java\\com\\shoalter\\ecommence\\inventorymanagementsystem\\reactivecache",
//                "C:\\work\\shoalter-ecommerce-business\\shoalter-ecommerce-business-hktv-iims\\src\\main\\java\\com\\shoalter\\ecommence\\inventorymanagementsystem\\request"
//        ));
//
//        put(INTERNAL, List.of(
//                "C:\\work\\shoalter-ecommerce-infra-master-repo\\shoalter-infra-internal-api-gateway\\src\\main\\java\\com\\shoalter\\ecommerce\\internalgateway\\filter",
//                "C:\\work\\shoalter-ecommerce-infra-master-repo\\shoalter-infra-internal-api-gateway\\src\\main\\java\\com\\shoalter\\ecommerce\\internalgateway\\service",
//                "C:\\work\\shoalter-ecommerce-infra-master-repo\\shoalter-infra-internal-api-gateway\\src\\main\\java\\com\\shoalter\\ecommerce\\internalgateway\\service\\impl",
//                "C:\\work\\shoalter-ecommerce-infra-master-repo\\shoalter-infra-internal-api-gateway\\src\\main\\java\\com\\shoalter\\ecommerce\\internalgateway\\utils",
//                "C:\\work\\shoalter-ecommerce-infra-master-repo\\shoalter-infra-internal-api-gateway\\src\\main\\java\\com\\shoalter\\ecommerce\\internalgateway\\converter",
//                "C:\\work\\shoalter-ecommerce-infra-master-repo\\shoalter-infra-internal-api-gateway\\src\\main\\java\\com\\shoalter\\ecommerce\\internalgateway\\mq"
//        ));
//
//        put(LOGIN, List.of(
//                "C:\\work\\shoalter-ecommerce-infra-master-repo\\shoalter-infra-login-service\\src\\main\\java\\hk\\com\\hktv\\hktvcustomerservice\\facade\\impl",
//                "C:\\work\\shoalter-ecommerce-infra-master-repo\\shoalter-infra-login-service\\src\\main\\java\\hk\\com\\hktv\\hktvcustomerservice\\service\\impl",
//                "C:\\work\\shoalter-ecommerce-infra-master-repo\\shoalter-infra-login-service\\src\\main\\java\\hk\\com\\hktv\\hktvcustomerservice\\utils",
//                "C:\\work\\shoalter-ecommerce-infra-master-repo\\shoalter-infra-login-service\\src\\main\\java\\hk\\com\\hktv\\hktvcustomerservice\\convertor"
//        ));
//
//        put(MOBILE, List.of(
//                "C:\\work\\shoalter-ecommerce-infra-master-repo\\shoalter-infra-mobile-api-gateway\\src\\main\\java\\com\\shoalter\\ecommerce\\mobilegateway\\client\\impl",
//                "C:\\work\\shoalter-ecommerce-infra-master-repo\\shoalter-infra-mobile-api-gateway\\src\\main\\java\\com\\shoalter\\ecommerce\\mobilegateway\\filter",
//                "C:\\work\\shoalter-ecommerce-infra-master-repo\\shoalter-infra-mobile-api-gateway\\src\\main\\java\\com\\shoalter\\ecommerce\\mobilegateway\\reactivecache",
//                "C:\\work\\shoalter-ecommerce-infra-master-repo\\shoalter-infra-mobile-api-gateway\\src\\main\\java\\com\\shoalter\\ecommerce\\mobilegateway\\repository",
//                "C:\\work\\shoalter-ecommerce-infra-master-repo\\shoalter-infra-mobile-api-gateway\\src\\main\\java\\com\\shoalter\\ecommerce\\mobilegateway\\service\\impl",
//                "C:\\work\\shoalter-ecommerce-infra-master-repo\\shoalter-infra-mobile-api-gateway\\src\\main\\java\\com\\shoalter\\ecommerce\\mobilegateway\\util"
//        ));
    }};
}
