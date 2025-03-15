package co.edu.uco.core.application.catalog.strategy.cache;

import co.edu.uco.core.domain.data.MessageData;
import co.edu.uco.core.domain.port.out.repository.CacheMessageRepository;
import co.edu.uco.core.domain.port.out.repository.SimplePage;
import co.edu.uco.core.domain.port.out.repository.SimplePageRequest;
import co.edu.uco.core.domain.port.out.repository.token.PageBuilder;
import co.edu.uco.utils.helper.UtilText;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

import static co.edu.uco.core.CrosswordsConstant.SINGLETON_SCOPE;
import static co.edu.uco.utils.helper.UtilUUID.getUUIDFromString;

@Component
@Scope(SINGLETON_SCOPE)
public final class CacheMessageCatalog extends CacheCatalog {
    private final CacheMessageRepository repository;

    public CacheMessageCatalog(CacheMessageRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<MessageData> getMessageById(String id) {
        return repository.findById(getUUIDFromString(id));
    }

    @Override
    public String getContent(String code) {
        return repository.findById(getUUIDFromString(code)).map(MessageData::getContent).orElse(UtilText.EMPTY);
    }

    @Override
    public void addMessage(MessageData messageModel) {
        repository.save(messageModel);
    }

    @Override
    public void addMessageWithEnvironment(MessageData messageModel, String environmentId) {
        repository.saveWithEnvironment(messageModel, environmentId);
    }

    @Override
    public boolean isExist(String key) {
        return getMessageById(key).isPresent();
    }

    @Override
    public Optional<MessageData> getMessage(String code, String application) {
        return repository.findApplicationMessageByCode(code, application);
    }

    @Override
    public SimplePage<MessageData> getMessage(String application, SimplePageRequest request) {
        var result = PageBuilder.createPageRequest(request);
        return repository.finByApplication(application, result);
    }

    @Override
    public SimplePage<MessageData> getMessageWithEnvironment(String environment, SimplePageRequest request) {
        var result = PageBuilder.createPageRequest(request);
        return repository.findMessagesByEnvironment(environment, result);
    }

    @Override
    public Optional<MessageData> getMessageByCodeAndEnvironment(String code, String environmentId) {
        return repository.findMessageByCodeAndEnvironment(code, environmentId);
    }

    @Override
    public SimplePage<MessageData> findByIdEnvironment(UUID id, SimplePageRequest pageRequest) {
        var result = PageBuilder.createPageRequest(pageRequest);
        return repository.findByIdEnvironment(id, result);
    }
}