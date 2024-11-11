package co.edu.uco.core.message.strategy.database;

import co.edu.uco.core.domain.data.MessageData;
import co.edu.uco.core.domain.port.out.repository.DataBaseMessageRepository;
import co.edu.uco.utils.exception.CrossWordsException;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static co.edu.uco.core.message.strategy.inmemory.enums.DetailMessageEnum.TCH_009;
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
        var response = repository.findApplicationMessageByCode(code, application);
        if (response.isEmpty()) {
            throw CrossWordsException.build(TCH_009.getContent());
        }
        return response;
    }
}