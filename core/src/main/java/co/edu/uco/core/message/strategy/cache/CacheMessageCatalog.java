package co.edu.uco.core.message.strategy.cache;

import co.edu.uco.core.domain.data.MessageData;
import co.edu.uco.core.domain.port.out.repository.CacheMessageRepository;
import co.edu.uco.utils.helper.UtilText;
import co.edu.uco.utils.helper.UtilUUID;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import static co.edu.uco.core.CrosswordsConstant.SINGLETON_SCOPE;

@Component
@Scope(SINGLETON_SCOPE)
public final class CacheMessageCatalog extends CacheCatalog {
    private final Map<UUID, MessageData> cache = new HashMap<>();
    private final CacheMessageRepository repository;
    public CacheMessageCatalog(CacheMessageRepository repository) {
        this.repository = repository;
    }

    @Override
    public MessageData getMessage(String code) {
        return null;
    }

    @Override
    public String getContent(String code) {
        Optional<MessageData> cachedMessage = repository.findApplicationMessageByCode(code, "application");
        return cachedMessage.map(messageData -> messageData.getContent().concat(" Consult with cache")).orElse(UtilText.EMPTY);
    }

    @Override
    public void addMessage(String key, MessageData messageModel) {
            repository.save(messageModel);
    }

    @Override
    public boolean isExist(String key) {
        return false;
    }

    @Override
    public Optional<MessageData> getMessage(String code, String application) {
        return repository.findApplicationMessageByCode(code, application);
    }
}