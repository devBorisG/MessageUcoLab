package co.edu.uco.core.messages.impl;

import co.edu.uco.core.domain.data.MessageData;
import co.edu.uco.core.domain.port.out.repository.CacheMessageRepository;
import co.edu.uco.core.messages.MessageCatalog;
import co.edu.uco.core.messages.MessageModel;
import co.edu.uco.core.messages.enums.MessageKeyEnum;
import co.edu.uco.utils.helper.UtilText;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static co.edu.uco.core.CrosswordsConstant.SINGLETON_SCOPE;

@Component
@Scope(SINGLETON_SCOPE)
public final class CacheMessageCatalog extends MessageCatalog {

    private final CacheMessageRepository repository;

    public CacheMessageCatalog(CacheMessageRepository repository) {
        this.repository = repository;
    }


    @Override
    public void loadCatalog() {

    }

    @Override
    public void reloadCatalog() {

    }

    @Override
    public MessageModel getMessage(MessageKeyEnum code) {
        return null;
    }

    @Override
    public String getContent(String code) {
        Optional<MessageData> cachedMessage = repository.findApplicationMessageByCode(code, "application");
        return cachedMessage.map(messageData -> messageData.getContent().concat(" Consult with cache")).orElse(UtilText.EMPTY);
    }

    @Override
    public void addMessage(MessageKeyEnum key, MessageModel messageModel) {}

    @Override
    public boolean isExist(MessageKeyEnum key) {
        return false;
    }
}