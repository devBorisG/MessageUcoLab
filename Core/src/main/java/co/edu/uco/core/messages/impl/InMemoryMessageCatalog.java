package co.edu.uco.core.messages.impl;

import co.edu.uco.core.CrosswordsConstant;
import co.edu.uco.core.messages.Message;
import co.edu.uco.core.messages.MessageCatalog;
import co.edu.uco.core.messages.MessageCatalogEnum;
import co.edu.uco.core.messages.MessageEnum;
import co.edu.uco.utils.exception.CrossWordsException;
import co.edu.uco.utils.helper.UtilObject;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Scope(CrosswordsConstant.SINGLETON_SCOPE)
public final class InMemoryMessageCatalog extends MessageCatalog {
    private Map<MessageCatalogEnum, Message> messages;
    @Override
    @PostConstruct
    public void loadCatalog() {
        messages = UtilObject.getDefaultIsNullObject(messages, new HashMap<>());
        for (var messageEnum : MessageEnum.values()) {
            messages.put(messageEnum.getCode(), messageEnum.getMessage());
        }
    }

    @Override
    public void reloadCatalog() {
        messages.clear();
        loadCatalog();
    }

    @Override
    public Message getMessage(MessageCatalogEnum code) {
        if (UtilObject.isNullObject(code)) {
            throw CrossWordsException.build(getContent(MessageCatalogEnum.TCH_007));
        }
        return messages.get(code);
    }

    @Override
    public String getContent(MessageCatalogEnum code) {
        if (UtilObject.isNullObject(code)) {
            throw CrossWordsException.build(getContent(MessageCatalogEnum.TCH_007));
        }
        return messages.get(code).content();
    }

    @Override
    public void addMessage(MessageCatalogEnum key, Message message) {
        messages.put(key, message);
    }

    @Override
    public boolean isExist(MessageCatalogEnum key) {
        return messages.containsKey(key);
    }
}
