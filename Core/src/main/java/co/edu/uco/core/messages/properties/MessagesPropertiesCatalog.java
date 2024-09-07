package co.edu.uco.core.messages.properties;

import co.edu.uco.core.CrosswordsConstant;
import co.edu.uco.core.messages.Message;
import co.edu.uco.core.messages.enums.MessageKeyEnum;
import co.edu.uco.core.messages.MessageCatalog;
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
@Scope(CrosswordsConstant.SINGLETON_SCOPE)
public class MessagesPropertiesCatalog extends MessageCatalog {

    private static final Map<MessageKeyEnum, Message> messagesCatalog = new HashMap<>();

    @PostConstruct
    public void init() {}

    @Override
    public Message getMessage(MessageKeyEnum key) {
        if (UtilObject.isNullObject(key)) {
           throw CrossWordsException.build(getContent(MessageKeyEnum.TCH_007));
        }
        return messagesCatalog.get(key);
    }

    @Override
    public String getContent(MessageKeyEnum code) {
        return messagesCatalog.get(code).content();
    }

    @Override
    public void addMessage(MessageKeyEnum key, Message message) {
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
    public boolean isExist(MessageKeyEnum key) {
        return messagesCatalog.containsKey(key);
    }
}