package co.edu.uco.core.message.strategy.inmemory;

import co.edu.uco.core.message.MessageModel;
import co.edu.uco.core.message.strategy.MessageCatalog;
import co.edu.uco.core.message.strategy.inmemory.enums.MessageKeyEnum;

public abstract class InMemoryCatalog extends MessageCatalog<MessageKeyEnum, MessageModel> {
    public abstract void loadCatalog();
    public abstract void reloadCatalog();
}