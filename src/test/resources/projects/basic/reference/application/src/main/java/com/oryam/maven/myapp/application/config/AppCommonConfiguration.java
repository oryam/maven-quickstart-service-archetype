package com.oryam.maven.myapp.application.config;

import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

import com.oryam.maven.myapp.common.CommonConfig;

@Profile("module-common")
@Import(CommonConfig.class)
public class AppCommonConfiguration {

}
