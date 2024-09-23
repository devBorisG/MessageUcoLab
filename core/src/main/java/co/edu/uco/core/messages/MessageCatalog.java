package co.edu.uco.core.messages;

import co.edu.uco.core.messages.enums.MessageKeyEnum;

public abstract class MessageCatalog {
    public abstract void loadCatalog();
    public abstract void reloadCatalog();
    public abstract MessageModel getMessage(MessageKeyEnum code);
    public abstract String getContent(String code);
    public abstract void addMessage(MessageKeyEnum key, MessageModel messageModel);
    public abstract boolean isExist(MessageKeyEnum key);
}