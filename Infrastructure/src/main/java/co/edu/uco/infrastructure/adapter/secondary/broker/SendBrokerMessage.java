package co.edu.uco.infrastructure.adapter.secondary.broker;

import co.edu.uco.core.application.dto.MessageDTO;
import co.edu.uco.core.port.out.broker.SendMessage;
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
    public void execute(MessageDTO entity) {
        try(Producer<String> stringProducer = this.client
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
