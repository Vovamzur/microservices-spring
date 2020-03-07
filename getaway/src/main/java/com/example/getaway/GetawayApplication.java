package com.example.getaway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@EnableDiscoveryClient
@SpringBootApplication
//@EnableEurekaClient
public class GetawayApplication {

//	@Bean
//	@LoadBalanced
//	public RestTemplate restTemplate () {
//		return new RestTemplate();
//	}
//
//	@Bean
//	public WebClient.Builder getWebClientBuilder () {
//		return WebClient.builder();
//	}

	@Bean
	public RouteLocator myRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(p -> p
						.path("/get")
						.uri("lb://countries-service/api/countries")
				)
				.build();
	}

	public static void main(String[] args) {
		SpringApplication.run(GetawayApplication.class, args);
	}

}
