package com.example.getaway.client;


import feign.Logger;
import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.form.FormEncoder;
import feign.gson.GsonDecoder;
import org.springframework.context.annotation.Bean;

public class CountrieServiceConfigurations {
    @Bean
    public Encoder feignFormEncoder() {
        return new FormEncoder();
    }

    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    public Decoder decoder(){
        return new GsonDecoder();
    }
}
