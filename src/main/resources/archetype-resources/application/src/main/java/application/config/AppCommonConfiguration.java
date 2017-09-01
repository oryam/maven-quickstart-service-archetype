#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.application.config;

import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

import ${package}.common.CommonConfig;

@Profile("module-common")
@Import(CommonConfig.class)
public class AppCommonConfiguration {

}
