package com.oryam.maven.myapp.application.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.oryam.maven.myapp.application.config.AppCommonConfiguration;
import com.oryam.maven.myapp.application.config.AppDomainConfiguration;
import com.oryam.maven.myapp.application.config.AppPersistenceConfiguration;
import com.oryam.maven.myapp.application.config.AppWebConfiguration;
import com.oryam.maven.myapp.application.config.CorsConfiguration;
import com.oryam.maven.myapp.application.config.OracleConfiguration;

@SpringBootApplication
@EnableCaching
@EnableAsync
@EnableScheduling
@Import({
          CorsConfiguration.class,
          OracleConfiguration.class,
          AppCommonConfiguration.class,
          AppDomainConfiguration.class,
          AppPersistenceConfiguration.class,
          AppWebConfiguration.class,
})
public class ApplicationBoot {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationBoot.class, args);
    }

}
