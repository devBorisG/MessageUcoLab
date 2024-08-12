package co.edu.uco.core.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "ucolab-usr")
public class PropertiesUserMessages{

    private Map<String, String> messages;

    public Map<String, String> getMessages() {
        return messages;
    }

    public void setMessages(Map<String, String> messages) {
        this.messages = messages;
    }

    public String getMessage(String key) {
        if (messages == null) {
            throw new IllegalStateException("Messages map is not initialized");
        }
        return messages.get(key);
    }
}
