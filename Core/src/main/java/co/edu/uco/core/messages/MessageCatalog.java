package co.edu.uco.core.messages;

public abstract class MessageCatalog {
    public abstract void loadCatalog();
    public abstract void reloadCatalog();
    public abstract Message getMessage(MessageCatalogEnum code);
    public abstract String getContent(MessageCatalogEnum code);
    public abstract void addMessage(MessageCatalogEnum key, Message message);

    public abstract Message getMessage(String key);

    public abstract boolean isExist(String key);
}
