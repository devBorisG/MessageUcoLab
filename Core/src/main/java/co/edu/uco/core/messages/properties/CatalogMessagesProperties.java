package co.edu.uco.core.messages.properties;

import co.edu.uco.core.messages.CatalogMessageEnum;
import co.edu.uco.core.messages.CatalogoMensajes;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "ucolab-usr")
@Slf4j
public class CatalogMessagesProperties extends CatalogoMensajes {

    private  Map<String, String> messages;

    private Map<String, String> messagesCatalog = new HashMap<>();

    public CatalogMessagesProperties() {
        this.messages = getMessages();
        this.messagesCatalog = messages;
    }

    public Map<String, String> getMessages() {
        return messages;
    }

    public void setMessages(Map<String, String> messages) {
        this.messages = messages;
    }

    @PostConstruct
    public void init() {
        cargarCatalogo();
        log.info("Catalogo de mensajes cargado");
    }

    public String getMessage(CatalogMessageEnum key) {
        return messagesCatalog.get(key.getKey());
    }

    @Override
    public void cargarCatalogo() {
        if (messages != null) {
            messagesCatalog.putAll(messages);
        }
    }

    @Override
    public void recargarCatalogo() {
        messagesCatalog.clear();
        cargarCatalogo();
    }

    @Override
    public String obtenerMensaje(String key) {
        return messagesCatalog.get(key);
    }

    @Override
    public void agregarMensaje(String key, String mensaje) {
        messagesCatalog.put(key, mensaje);
    }

    @Override
    public boolean contieneMensaje(String key) {
        return messagesCatalog.containsKey(key);
    }
}
