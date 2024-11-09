package co.edu.uco.core.message.strategy.database;

import co.edu.uco.core.domain.data.MessageData;
import co.edu.uco.core.domain.port.out.repository.DataBaseMessageRepository;
import co.edu.uco.utils.exception.CrossWordsException;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

import static co.edu.uco.core.message.strategy.inmemory.enums.DetailMessageEnum.TCH_009;
import static co.edu.uco.utils.helper.UtilText.EMPTY;
import static co.edu.uco.core.CrosswordsConstant.SINGLETON_SCOPE;

@Component
@Scope(SINGLETON_SCOPE)
public final class DatabaseMessageCatalog extends DatabaseCatalog {
    private final DataBaseMessageRepository repository;
    public DatabaseMessageCatalog(DataBaseMessageRepository repository) {
        this.repository = repository;
    }
    @Override
    public void loadCatalog() {}
    @Override
    public void reloadCatalog() {}
    @Override
    public MessageData getMessage(List<String> code) {
        var response = repository.findApplicationMessageByCode(code.get(0), code.get(1));
        if (response.isEmpty()) {
            throw CrossWordsException.build(TCH_009.getContent());
        }
        return response.get();
    }
    @Override
    public String getContent(String code) {
        return repository.toString();
    }
    @Override
    public void addMessage(List<String> key, MessageData messageModel) {
        repository.save(messageModel);
    }
    @Override
    public boolean isExist(List<String> key) {
        return false;
    }
}