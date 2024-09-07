package co.edu.uco.core.messages;

import co.edu.uco.core.messages.enums.MessageKeyEnum;

public abstract class MessageCatalog {
    public abstract void loadCatalog();
    public abstract void reloadCatalog();
    public abstract Message getMessage(MessageKeyEnum code);
    public abstract String getContent(MessageKeyEnum code);
    public abstract void addMessage(MessageKeyEnum key, Message message);
    public abstract boolean isExist(MessageKeyEnum key);
}