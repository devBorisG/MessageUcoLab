package co.edu.uco.core.messages.properties;

import co.edu.uco.core.CrosswordConstants;
import co.edu.uco.core.messages.Message;
import co.edu.uco.core.messages.MessageCatalogEnum;
import co.edu.uco.core.messages.MessageCatalog;
import co.edu.uco.core.messages.MessageEnum;
import co.edu.uco.utils.exception.CrossWordsException;
import co.edu.uco.utils.helper.UtilObject;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.HashMap;
import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "ucolab-usr")
@Scope("singleton")
public class MessagesPropertiesCatalog extends MessageCatalog {

    private static final Map<MessageCatalogEnum, Message> messagesCatalog = new HashMap<>();

    @PostConstruct
    public void init() {}

    public Message getMessage(MessageCatalogEnum key) {
        if (UtilObject.isNullObject(key)) {
           throw CrossWordsException.build(getContent(MessageCatalogEnum.TCH_007));
        }
        return messagesCatalog.get(key);
    }

    @Override
    public String getContent(MessageCatalogEnum code) {
        return messagesCatalog.get(code).content();
    }

    @Override
    public void addMessage(MessageCatalogEnum key, Message message) {
        messagesCatalog.put(key, message);
    }

    @Override
    public void loadCatalog() {}

    @Override
    public void reloadCatalog() {
        messagesCatalog.clear();
        loadCatalog();
    }

    @Override
    public Message getMessage(String key) {
        return messagesCatalog.get(key);
    }


    @Override
    public boolean isExist(String key) {
        return messagesCatalog.containsKey(key);
    }

    public static void main(String[] args) {
        var message = MessageEnum.TCH_001.getMessage();
        System.out.println(message.code().getKey()+" "+message.content()+" "+message.title()+" "+message.type()+" "+message.category());
    }
}