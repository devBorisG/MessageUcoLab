package co.edu.uco.infrastructure.init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@ComponentScan(basePackages = {"co.edu.uco"})
@EnableMongoRepositories(basePackages = {"co.edu.uco.core"})
@EnableCaching
public class CrossWordApplication {


    public static void main(String[] args) {
        SpringApplication.run(CrossWordApplication.class, args);
    }

}
