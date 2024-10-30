package co.edu.uco.infrastructure.init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@ComponentScan(basePackages = {"co.edu.uco"})
@EnableMongoRepositories(basePackages = {"co.edu.uco.infrastructure.adapter.secondary.repository"})
@EnableRedisRepositories(basePackages = {"co.edu.uco.infrastructure.adapter.secondary.repository"})
@EnableCaching
public class CrossWordApplication {
    public static void main(String[] args) {
        SpringApplication.run(CrossWordApplication.class, args);
    }
}