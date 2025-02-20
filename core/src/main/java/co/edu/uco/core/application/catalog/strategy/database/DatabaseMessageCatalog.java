package co.edu.uco.core.application.catalog.strategy.database;

import co.edu.uco.core.domain.data.MessageData;
import co.edu.uco.core.domain.port.out.repository.DataBaseMessageRepository;
import co.edu.uco.core.domain.port.out.repository.PageBuilder;
import co.edu.uco.core.domain.port.out.repository.SimplePage;
import co.edu.uco.core.domain.port.out.repository.SimplePageRequest;
import co.edu.uco.utils.helper.UtilUUID;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

import static co.edu.uco.core.CrosswordsConstant.SINGLETON_SCOPE;
import static co.edu.uco.utils.helper.UtilText.EMPTY;

@Component
@Scope(SINGLETON_SCOPE)
public final class DatabaseMessageCatalog extends DatabaseCatalog {
    private final DataBaseMessageRepository repository;
    public DatabaseMessageCatalog(DataBaseMessageRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<MessageData> getMessageById(String code) {
        return repository.findById(UtilUUID.getUUIDFromString(code));
    }

    @Override
    public String getContent(String code) {
        return repository.findById(UtilUUID.getUUIDFromString(code)).map(MessageData::getContent).orElse(EMPTY);
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
        var  result = PageBuilder.createPageRequest(request);
        return repository.finByApplication(application, result);
    }

    @Override
    public List<MessageData> getMessages(String application) {
        return repository.finByApplication(application);
    }
}