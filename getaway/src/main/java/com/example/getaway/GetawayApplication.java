package com.example.getaway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@Configuration
@EnableAutoConfiguration
@EnableDiscoveryClient
@SpringBootApplication
public class GetawayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GetawayApplication.class, args);
    }
}
