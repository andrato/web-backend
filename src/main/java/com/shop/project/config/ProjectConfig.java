package com.shop.project.config;

import com.shop.project.mapper.ProductMapper;
import com.shop.project.mapper.ProductMapperImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {
    @Bean
    public ProductMapper productMapper () {
        return new ProductMapperImpl();
    }
}
