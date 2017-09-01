#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.domain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import ${package}.common.CommonConfig;

@SpringBootApplication
@Import({ CommonConfig.class })
public class ApplicationDomainConfigTest {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationDomainConfigTest.class, args);
    }

}
