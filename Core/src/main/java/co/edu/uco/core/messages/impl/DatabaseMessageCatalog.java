package co.edu.uco.core.messages.impl;

import co.edu.uco.core.messages.MessageCatalog;
import org.springframework.stereotype.Component;

@Component
public final class DatabaseMessageCatalog extends MessageCatalog {
    @Override
    public void loadCatalog() {

    }

    @Override
    public void reloadCatalog() {

    }

    @Override
    public String getMessage(String key) {
        return "";
    }

    @Override
    public void addMessage(String key, String message) {

    }

    @Override
    public boolean isExist(String key) {
        return false;
    }
}
