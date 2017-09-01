package com.oryam.maven.myapp.application.config;

import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

import com.oryam.maven.myapp.domain.DomainConfig;

@Profile("module-domain")
@Import(DomainConfig.class)
public class AppDomainConfiguration {

}
