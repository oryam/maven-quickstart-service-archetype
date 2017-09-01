package com.oryam.maven.myapp.test.integration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.oryam.maven.myapp.common.CommonConfig;
import com.oryam.maven.myapp.domain.DomainConfig;
import com.oryam.maven.myapp.persistence.jpa.PersistenceConfig;
import com.oryam.maven.myapp.web.WebConfig;

@SpringBootApplication
@Import({ CommonConfig.class, DomainConfig.class, PersistenceConfig.class, WebConfig.class })
public class ApplicationIntegrationConfigTest {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationIntegrationConfigTest.class, args);
    }

}
