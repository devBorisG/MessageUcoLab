package co.edu.uco.infrastructure.configuration;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

import static co.edu.uco.infrastructure.configuration.InfrastructureConstant.PACKAGE_REPOSITORY_POSTGRESQL_ADAPTER;

@Configuration
@EnableJpaRepositories(basePackages=PACKAGE_REPOSITORY_POSTGRESQL_ADAPTER)
public class JpaConfig {
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5435/crs-crossword-db");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres");
        return dataSource;
    }
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(dataSource);
        emf.setPackagesToScan("co.edu.uco.infrastructure.adapter.secondary.repository.entity");
        emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        // Configuraciones adicionales de JPA
        emf.getJpaPropertyMap().put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        emf.getJpaPropertyMap().put("hibernate.show_sql", true);
        return emf;
    }
    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }
}