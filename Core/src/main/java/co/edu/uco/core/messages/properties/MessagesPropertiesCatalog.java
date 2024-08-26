package co.edu.uco.core.messages.properties;

import co.edu.uco.core.messages.MessageCatalogEnum;
import co.edu.uco.core.messages.MessageCatalog;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "ucolab-usr")
@Slf4j
public  class MessagesPropertiesCatalog extends MessageCatalog {

    private  Map<String, String> messages;

    private Map<String, String> messagesCatalog = new HashMap<>();

    public final Map<String, String> getMessages() {
        return messages;
    }

    public void setMessages(Map<String, String> messages) {
        this.messages = messages;
    }

    @PostConstruct
    public void init() {
        loadCatalog();
        log.info("Catalogo de mensajes cargado");
    }

    public String getMessage(MessageCatalogEnum key) {
        return messagesCatalog.get(key.getKey());
    }

    @Override
    public void loadCatalog() {
        if (messages != null) {
            messagesCatalog.putAll(messages);
        }
    }

    @Override
    public void reloadCatalog() {
        messagesCatalog.clear();
        loadCatalog();
    }

    @Override
    public String getMessage(String key) {
        return messagesCatalog.get(key);
    }

    @Override
    public void addMessage(String key, String message) {
        messagesCatalog.put(key, message);
    }

    @Override
    public boolean isExist(String key) {
        return messagesCatalog.containsKey(key);
    }
}
