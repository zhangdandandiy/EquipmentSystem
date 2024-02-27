package com.example.pmp.common;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class DataFetcher {
    private final RestTemplate restTemplate;

    public DataFetcher(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public String fetchData(String apiUrl) {
        return restTemplate.getForObject(apiUrl, String.class);
    }
}
