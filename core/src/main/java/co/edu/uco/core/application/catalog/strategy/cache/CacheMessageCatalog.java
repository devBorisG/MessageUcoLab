package co.edu.uco.core.application.catalog.strategy.cache;

import co.edu.uco.core.domain.data.MessageData;
import co.edu.uco.core.domain.port.out.repository.CacheMessageRepository;
import co.edu.uco.core.domain.port.out.repository.SimplePage;
import co.edu.uco.core.domain.port.out.repository.SimplePageRequest;
import co.edu.uco.utils.helper.UtilText;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.Optional;

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
    public boolean isExist(String key) {
        return getMessageById(key).isPresent();
    }

    @Override
    public Optional<MessageData> getMessage(String code, String application) {
        return repository.findApplicationMessageByCode(code, application);
    }

    @Override
    public SimplePage<MessageData> getMessage(String application, SimplePageRequest request) {
        var  result = PageRequest.of(request.getPage(), request.getSize(), Sort.by(Sort.Direction.fromString(request.getSort()), request.getColumnSort()));
        return repository.finByApplication(application, result);
    }
}