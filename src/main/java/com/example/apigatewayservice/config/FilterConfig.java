package com.example.apigatewayservice.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class FilterConfig {

    //@Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder){
        return builder.routes()
                .route(r -> r.path("/first-service/**") // path 설정
                        .filters(f -> f.addRequestHeader("first-request", "first-request-header")   // request header에 정보 추가
                                .addResponseHeader("first-response", "first-response-header"))  //response header에 정보 추가
                        .uri("http://localhost:8081/"))
                .route(r -> r.path("/second-service/**") // path 설정
                        .filters(f -> f.addRequestHeader("second-request", "second-request-header")   // request header에 정보 추가
                                .addResponseHeader("second-response", "second-response-header"))  //response header에 정보 추가
                        .uri("http://localhost:8082/"))
                .build();
    }

}
