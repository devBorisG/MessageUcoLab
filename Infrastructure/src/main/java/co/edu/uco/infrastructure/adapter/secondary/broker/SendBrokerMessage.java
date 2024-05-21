package co.edu.uco.infrastructure.adapter.secondary.broker;

import co.edu.uco.core.domain.entities.MessageEntity;
import co.edu.uco.core.domain.port.out.broker.SendMessage;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.pulsar.client.api.Producer;
import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.PulsarClientException;
import org.apache.pulsar.client.api.Schema;
import org.springframework.stereotype.Component;

@Component
public class SendBrokerMessage implements SendMessage {

    private final PulsarClient client;
    public SendBrokerMessage(PulsarClient client) {
        this.client = client;
    }

    @Override
    public void execute(MessageEntity entity, HttpServletResponse response) {
        try (Producer<String> stringProducer = this.client
                .newProducer(Schema.STRING)
                .topic("test-topic")
                .create()) {
            for (int i = 0; i < 1000; i++){
                stringProducer.send(entity.toString());
            }
        } catch (PulsarClientException ex) {
            throw new RuntimeException(ex);
        }
    }

}
