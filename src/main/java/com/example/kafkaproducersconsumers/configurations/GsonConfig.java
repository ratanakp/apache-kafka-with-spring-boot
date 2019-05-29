package com.example.kafkaproducersconsumers.configurations;

import com.google.gson.Gson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GsonConfig {


    @Bean
    public Gson jsonConverter() {
        return new Gson();
    }
}
