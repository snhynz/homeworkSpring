package com.homework.homeworkSpring;

import com.homework.homeworkSpring.model.Product;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    @ConfigurationProperties("senih")
    public Product getProduct(){
        return new Product();
    }}
