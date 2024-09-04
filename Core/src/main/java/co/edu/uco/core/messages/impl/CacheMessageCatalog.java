package co.edu.uco.core.messages.impl;

import co.edu.uco.core.messages.Message;
import co.edu.uco.core.messages.MessageCatalog;
import co.edu.uco.core.messages.MessageCatalogEnum;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public final class CacheMessageCatalog extends MessageCatalog {

    @Override
    public void loadCatalog() {

    }

    @Override
    public void reloadCatalog() {

    }

    @Override
    public Message getMessage(MessageCatalogEnum code) {
        return null;
    }

    @Override
    public String getContent(MessageCatalogEnum code) {
        return "";
    }

    @Override
    public void addMessage(MessageCatalogEnum key, Message message) {

    }

    @Override
    public Message getMessage(String key) {
        return null;
    }


    @Override
    public boolean isExist(String key) {
        return false;
    }
}