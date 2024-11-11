package co.edu.uco.core.message.strategy;

public abstract class MessageCatalog<K, T> {
    public abstract T getMessage(K code);
    public abstract String getContent(String code);
    public abstract void addMessage(K key, T messageModel);
    public abstract boolean isExist(K key);
}