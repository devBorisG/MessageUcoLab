package co.edu.uco.infrastructure.init;

import co.edu.uco.core.messages.CatalogMessageEnum;
import co.edu.uco.core.messages.CatalogoMensajes;
import co.edu.uco.core.messages.properties.CatalogMessagesProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"co.edu.uco"})
public class CrossWordApplication {


    public static void main(String[] args) {
        SpringApplication.run(CrossWordApplication.class, args);
    }

}
