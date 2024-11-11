package co.edu.uco.core.message.strategy.database;

import co.edu.uco.core.domain.data.MessageData;
import co.edu.uco.core.domain.port.out.repository.DataBaseMessageRepository;
import co.edu.uco.core.domain.port.out.repository.SimplePage;
import co.edu.uco.core.domain.port.out.repository.SimplePageRequest;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

import static co.edu.uco.core.CrosswordsConstant.SINGLETON_SCOPE;

@Component
@Scope(SINGLETON_SCOPE)
public final class DatabaseMessageCatalog extends DatabaseCatalog {
    private final DataBaseMessageRepository repository;
    public DatabaseMessageCatalog(DataBaseMessageRepository repository) {
        this.repository = repository;
    }

    @Override
    public MessageData getMessage(String code) {
        return null;
    }

    @Override
    public String getContent(String code) {
        return repository.toString();
    }
    @Override
    public void addMessage(String key, MessageData messageModel) {
    }
    @Override
    public boolean isExist(String key) {
        return false;
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

    @Override
    public List<MessageData> getMessages(String application) {
        return repository.finByApplication(application);
    }
}