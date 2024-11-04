package co.edu.uco.infrastructure.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = {"co.edu.uco.infrastructure.adapter.secondary.repository"})
public class MongoDbConfig {}