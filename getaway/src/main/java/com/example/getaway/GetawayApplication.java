package com.example.getaway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class GetawayApplication {
//    @Bean
//    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
//        return builder.routes()
//                .route(p -> p
//                        .path("/countries/**")
//                        .filters(f -> f.stripPrefix(1))
//                        .uri("lb://countries-service/api/countries")
//                        .id("countries-service")
//                )
//                .build();
//    }


    public static void main(String[] args) {
        SpringApplication.run(GetawayApplication.class, args);
    }

}
