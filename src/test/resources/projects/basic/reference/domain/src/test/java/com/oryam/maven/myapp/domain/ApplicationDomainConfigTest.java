package com.oryam.maven.myapp.domain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.oryam.maven.myapp.common.CommonConfig;

@SpringBootApplication
@Import({ CommonConfig.class })
public class ApplicationDomainConfigTest {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationDomainConfigTest.class, args);
    }

}
