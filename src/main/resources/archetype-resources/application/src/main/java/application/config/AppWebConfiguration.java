#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.application.config;

import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

import ${package}.web.WebConfig;

@Profile("module-web")
@Import(WebConfig.class)
public class AppWebConfiguration {

}
