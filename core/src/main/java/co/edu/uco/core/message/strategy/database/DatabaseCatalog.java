package co.edu.uco.core.message.strategy.database;

import co.edu.uco.core.domain.data.MessageData;
import co.edu.uco.core.message.strategy.MessageCatalog;

import java.util.Optional;

public abstract class DatabaseCatalog extends MessageCatalog<String, MessageData> {
    public abstract Optional<MessageData> getMessage(String code, String application);
}