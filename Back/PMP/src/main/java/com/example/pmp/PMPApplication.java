package com.example.pmp;

import com.example.pmp.config.CorsConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@Import(CorsConfig.class)
@EnableScheduling
public class PMPApplication {

    public static void main(String[] args) {
        SpringApplication.run(PMPApplication.class, args);
//        Dog dog = new Dog();
//        dog.setAge(1);
//        dog.setBreed("lab");
//        dog.setColour("yellow");
//        dog.setSize(20);
//
//        Field[] fields = dog.getClass().getDeclaredFields();
//        for (Field field : fields){
//            System.out.println(field.getName());
//        }
//        System.out.println(fields);
    }

    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();

        // 配置 MappingJackson2HttpMessageConverter
        List<HttpMessageConverter<?>> converters = new ArrayList<>();
        converters.add(new MappingJackson2HttpMessageConverter());
        restTemplate.setMessageConverters(converters);

        return restTemplate;
    }

}
