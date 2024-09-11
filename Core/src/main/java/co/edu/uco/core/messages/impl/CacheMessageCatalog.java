package co.edu.uco.core.messages.impl;

import co.edu.uco.core.messages.Message;
import co.edu.uco.core.messages.MessageCatalog;
import co.edu.uco.core.messages.enums.MessageKeyEnum;
import co.edu.uco.utils.helper.UtilObject;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static co.edu.uco.core.CrosswordsConstant.SINGLETON_SCOPE;

@Component
@Scope(SINGLETON_SCOPE)
public final class CacheMessageCatalog extends MessageCatalog {

    private Map<MessageKeyEnum, Message> messages; // TODO cambair e integrar estrategia de persistencia

    @Override
    @PostConstruct
    public void loadCatalog() {
        messages = UtilObject.getDefaultIsNullObject(messages, new ConcurrentHashMap<>());
    }

    @Override
    public void reloadCatalog() {

    }

    @Override
    public Message getMessage(MessageKeyEnum code) {
        return null;
    }

    @Override
    public String getContent(MessageKeyEnum code) {
        return "";
    }

    @Override
    public void addMessage(MessageKeyEnum key, Message message) {

    }

    @Override
    public boolean isExist(MessageKeyEnum key) {
        return false;
    }
}