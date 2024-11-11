package co.edu.uco.core.message.strategy.cache;

import co.edu.uco.core.domain.data.MessageData;
import co.edu.uco.core.domain.port.out.repository.SimplePage;
import co.edu.uco.core.domain.port.out.repository.SimplePageRequest;
import co.edu.uco.core.message.strategy.MessageCatalog;

import java.util.Optional;

public abstract class CacheCatalog  extends MessageCatalog<String, MessageData> {
    public abstract Optional<MessageData> getMessage(String code, String application);
    public abstract SimplePage<MessageData> getMessage(String application, SimplePageRequest request);
}