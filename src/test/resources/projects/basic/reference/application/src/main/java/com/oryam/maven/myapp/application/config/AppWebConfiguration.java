package com.oryam.maven.myapp.application.config;

import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

import com.oryam.maven.myapp.web.WebConfig;

@Profile("module-web")
@Import(WebConfig.class)
public class AppWebConfiguration {

}
