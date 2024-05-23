package com.example.current.weather.config;

import com.example.current.weather.models.Location;
import com.example.current.weather.models.WeatherData;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class BeansConfig {
    @Bean
    public WebClient webClient() {
        return WebClient.builder().build();
    }

}
