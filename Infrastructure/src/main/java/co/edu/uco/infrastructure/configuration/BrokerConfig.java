package co.edu.uco.infrastructure.configuration;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.PulsarClientException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BrokerConfig {
    private PulsarClient client;

    @PostConstruct
    public void init() throws PulsarClientException {
        this.client = PulsarClient.builder()
                .serviceUrl("pulsar://localhost:6650")
                .build();
    }

    @Bean
    public PulsarClient pulsarClient() {
        return this.client;
    }

    @PreDestroy
    public void cleanup() throws PulsarClientException {
        if (this.client != null) {
            this.client.close();
        }
    }

}
