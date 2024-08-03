package co.edu.uco.infrastructure.adapter.secondary.broker;

import co.edu.uco.core.domain.domains.MessageCodeDomain;
import co.edu.uco.core.domain.port.out.broker.SendMessage;
import co.edu.uco.core.properties.PropertiesCatalogMessageProducer;
import co.edu.uco.utils.exception.enumeration.infrastructure.SendBrokerMessageCustomException;
import co.edu.uco.utils.mapper.json.UtilMapperJson;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.pulsar.client.api.Producer;
import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.PulsarClientException;
import org.apache.pulsar.client.api.Schema;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@EnableConfigurationProperties(PropertiesCatalogMessageProducer.class)
public class SendBrokerMessage implements SendMessage {

    private final PulsarClient client;
    private final UtilMapperJson utilMapperJson;
    private final PropertiesCatalogMessageProducer messageProducer;

    public SendBrokerMessage(PulsarClient client, UtilMapperJson utilMapperJson, @Qualifier("propertiesCatalogMessageProducer") PropertiesCatalogMessageProducer messageProducer) {
        this.client = client;
        this.utilMapperJson = utilMapperJson;
        this.messageProducer = messageProducer;
    }

    @Override
    public void execute(MessageCodeDomain messageDomain, HttpServletResponse response) {
        try (Producer<String> stringProducer = this.client
                .newProducer(Schema.STRING)
                .topic(messageProducer.getTopic())
                .create()) {
                    Optional<String> message = utilMapperJson.execute(messageDomain);
                    if(message.isPresent()){
                        stringProducer.send(message.get());
                    }
        } catch (PulsarClientException ex) {
            throw SendBrokerMessageCustomException.buildTechnicalException(ex.getMessage(), ex);
        } catch (Exception ex){
            throw SendBrokerMessageCustomException.buildTechnicalException(ex.getMessage());
        }
    }
}