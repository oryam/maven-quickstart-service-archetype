#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.test.integration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import ${package}.common.CommonConfig;
import ${package}.domain.DomainConfig;
import ${package}.persistence.jpa.PersistenceConfig;
import ${package}.web.WebConfig;

@SpringBootApplication
@Import({ CommonConfig.class, DomainConfig.class, PersistenceConfig.class, WebConfig.class })
public class ApplicationIntegrationConfigTest {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationIntegrationConfigTest.class, args);
    }

}
