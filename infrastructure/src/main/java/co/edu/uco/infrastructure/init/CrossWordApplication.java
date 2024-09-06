package co.edu.uco.infrastructure.init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"co.edu.uco"})
public class CrossWordApplication {


    public static void main(String[] args) {
        SpringApplication.run(CrossWordApplication.class, args);
    }

}
