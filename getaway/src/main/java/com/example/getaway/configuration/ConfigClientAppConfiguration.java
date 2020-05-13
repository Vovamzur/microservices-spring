package com.example.getaway.configuration;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Getter
@RefreshScope
@Component
@ConfigurationProperties(prefix = "getaway")
public class ConfigClientAppConfiguration {
    @Value("${getaway.property1}")
    String property1;

    @Value("${getaway.property2}")
    String property2;
}
