package co.edu.uco.infrastructure.configuration;

import co.edu.uco.infrastructure.adapter.secondary.presenter.serializer.SerializerType;
import co.edu.uco.infrastructure.adapter.secondary.presenter.serializer.impl.json.JsonSerializer;
import co.edu.uco.infrastructure.adapter.secondary.presenter.serializer.impl.yaml.YamlSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SerializerConfig {

    @Bean
    public SerializerType jsonSerializer() {
        return new JsonSerializer();
    }

    @Bean
    public SerializerType yamlSerializer() {
        return new YamlSerializer();
    }
}
