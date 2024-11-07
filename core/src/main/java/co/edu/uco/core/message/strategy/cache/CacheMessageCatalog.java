package co.edu.uco.core.message.strategy.cache;

import co.edu.uco.core.domain.data.MessageData;
import co.edu.uco.core.domain.port.out.repository.CacheMessageRepository;
import co.edu.uco.utils.exception.CrossWordsException;
import co.edu.uco.utils.helper.UtilText;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

import static co.edu.uco.core.CrosswordsConstant.SINGLETON_SCOPE;
import static co.edu.uco.core.message.strategy.inmemory.enums.DetailMessageEnum.TCH_009;

@Component
@Scope(SINGLETON_SCOPE)
public final class CacheMessageCatalog extends CacheCatalog {
    private final CacheMessageRepository repository;
    public CacheMessageCatalog(CacheMessageRepository repository) {
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
        Optional<MessageData> cachedMessage = repository.findApplicationMessageByCode(code, "application");
        return cachedMessage.map(messageData -> messageData.getContent().concat(" Consult with cache")).orElse(UtilText.EMPTY);
    }
    @Override
    public void addMessage(List<String> key, MessageData messageModel) {
    }
    @Override
    public boolean isExist(List<String> key) {
        return false;
    }
}