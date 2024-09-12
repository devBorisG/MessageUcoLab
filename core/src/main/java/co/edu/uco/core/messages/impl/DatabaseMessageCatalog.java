package co.edu.uco.core.messages.impl;

import co.edu.uco.core.domain.port.out.db.mongo.IMongoRepository;
import co.edu.uco.core.messages.MessageModel;
import co.edu.uco.core.messages.MessageCatalog;
import co.edu.uco.core.messages.enums.DetailMessageEnum;
import co.edu.uco.core.messages.enums.MessageKeyEnum;
import co.edu.uco.utils.helper.UtilObject;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static co.edu.uco.core.CrosswordsConstant.SINGLETON_SCOPE;

@Component
@Scope(SINGLETON_SCOPE)
public final class DatabaseMessageCatalog extends MessageCatalog {

    private final IMongoRepository mongoRepository;

    public DatabaseMessageCatalog(IMongoRepository mongoRepository) {
        this.mongoRepository = mongoRepository;
    }

    @Override
    @PostConstruct
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
    public String getContent(MessageKeyEnum code) {
        return mongoRepository.findById(code.getKey()).get().getContent();
    }

    @Override
    public void addMessage(MessageKeyEnum key, MessageModel messageModel) {

    }

    @Override
    public boolean isExist(MessageKeyEnum key) {
        return false;
    }
}
