#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.application.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import ${package}.application.config.AppCommonConfiguration;
import ${package}.application.config.AppDomainConfiguration;
import ${package}.application.config.AppPersistenceConfiguration;
import ${package}.application.config.AppWebConfiguration;
import ${package}.application.config.CorsConfiguration;
import ${package}.application.config.OracleConfiguration;

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
