package co.edu.uco.core.messages.impl;

import co.edu.uco.core.CrosswordsConstant;
import co.edu.uco.core.messages.Message;
import co.edu.uco.core.messages.MessageCatalog;
import co.edu.uco.core.messages.enums.MessageKeyEnum;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(CrosswordsConstant.SINGLETON_SCOPE)
public final class CacheMessageCatalog extends MessageCatalog {

    @Override
    public void loadCatalog() {

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