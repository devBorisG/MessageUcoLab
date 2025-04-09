package co.edu.uco.infrastructure.configuration;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.PulsarClientException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static co.edu.uco.infrastructure.configuration.InfrastructureConstant.PULSAR_CLIENT_HOST;
import static co.edu.uco.utils.helper.UtilObject.isNullObject;

@Configuration
public class BrokerConfig {
    private PulsarClient client;
    @PostConstruct
    public void init() throws PulsarClientException {
        this.client = PulsarClient.builder()
                .serviceUrl(PULSAR_CLIENT_HOST)
                .build();
    }
    @Bean
    public PulsarClient pulsarClient() {
        return this.client;
    }
    @PreDestroy
    public void cleanup() throws PulsarClientException {
        if (!isNullObject(this.client)) {
            this.client.close();
        }
    }
}