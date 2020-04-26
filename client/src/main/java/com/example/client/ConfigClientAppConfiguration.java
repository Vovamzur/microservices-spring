package com.example.client;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Getter
@RefreshScope
@Component
@ConfigurationProperties(prefix = "countries-service")
public class ConfigClientAppConfiguration {
    @Value("${countries-service.property1}")
    String property1;

    @Value("${countries-service.property2}")
    String property2;
}
