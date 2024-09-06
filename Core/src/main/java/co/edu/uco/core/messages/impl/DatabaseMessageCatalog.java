package co.edu.uco.core.messages.impl;

import co.edu.uco.core.CrosswordsConstant;
import co.edu.uco.core.messages.Message;
import co.edu.uco.core.messages.MessageCatalog;
import co.edu.uco.core.messages.MessageCatalogEnum;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(CrosswordsConstant.SINGLETON_SCOPE)
public final class DatabaseMessageCatalog extends MessageCatalog {
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
    public boolean isExist(MessageCatalogEnum key) {
        return false;
    }
}
