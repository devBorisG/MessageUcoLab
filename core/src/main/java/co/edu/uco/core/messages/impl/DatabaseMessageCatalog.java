package co.edu.uco.core.messages.impl;

import co.edu.uco.core.domain.port.out.repository.DataBaseMessageRepository;
import co.edu.uco.core.messages.MessageModel;
import co.edu.uco.core.messages.MessageCatalog;
import co.edu.uco.core.messages.enums.MessageKeyEnum;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static co.edu.uco.utils.helper.UtilText.EMPTY;
import static co.edu.uco.core.CrosswordsConstant.SINGLETON_SCOPE;

@Component
@Scope(SINGLETON_SCOPE)
public final class DatabaseMessageCatalog extends MessageCatalog {
    private final DataBaseMessageRepository messageRepository;
    public DatabaseMessageCatalog(DataBaseMessageRepository messageRepository) {
        this.messageRepository = messageRepository;
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
        return messageRepository.findApplicationMessageByCode(code,"application")
                .map(message -> {
                    // TODO Aqui deberia guardar en cache (tengo pensado hacer algun facade o usecase que haga eso para segregar responsabilidad).
                    messageRepository.save(message);
                    return message.getContent();
                })
                .orElse(EMPTY);
    }

    @Override
    public void addMessage(MessageKeyEnum key, MessageModel messageModel) {
     // TODO: Implementar
    }

    @Override
    public boolean isExist(MessageKeyEnum key) {
        return false;
    }
}
