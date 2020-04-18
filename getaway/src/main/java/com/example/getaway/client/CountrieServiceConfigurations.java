package com.example.getaway.client;

import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import org.springframework.context.annotation.Bean;

public class CountrieServiceConfigurations {

    @Bean
    public Encoder encoder() {
        return new GsonEncoder();
    }

    @Bean
    public Decoder decoder() {
        return new GsonDecoder();
    }
}
