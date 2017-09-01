package com.oryam.maven.myapp.application.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class CorsConfiguration {

    private static final Logger LOG = LoggerFactory.getLogger(CorsConfiguration.class);

    @Value("${cors.security.origins}")
    private String[] origins;

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                LOG.info("Allowed request origins from {} servers {}", origins.length, origins);

                registry.addMapping("/**")
                        .allowedOrigins(origins)
                        .allowedMethods(org.springframework.web.cors.CorsConfiguration.ALL)
                        .allowCredentials(true)
                        .maxAge(3600);
            }
        };
    }

}
