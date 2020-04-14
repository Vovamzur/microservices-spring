package com.example.getaway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;

// @EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients("com.example.getaway.client")
@EnableCircuitBreaker
public class GetawayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GetawayApplication.class, args);
    }
}
