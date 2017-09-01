package com.oryam.maven.myapp.application.config;

import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

import com.oryam.maven.myapp.persistence.jpa.PersistenceConfig;

@Profile("module-persistence")
@Import(PersistenceConfig.class)
public class AppPersistenceConfiguration {

}
