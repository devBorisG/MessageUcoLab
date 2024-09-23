package co.edu.uco.core.messages.impl;

import co.edu.uco.core.assembler.pojo.Message;
import co.edu.uco.core.domain.port.out.db.mongo.IMongoRepository;
import co.edu.uco.core.messages.MessageModel;
import co.edu.uco.core.messages.MessageCatalog;
import co.edu.uco.core.messages.enums.DetailMessageEnum;
import co.edu.uco.core.messages.enums.MessageKeyEnum;
import co.edu.uco.utils.exception.CrossWordsException;
import co.edu.uco.utils.helper.UtilObject;
import co.edu.uco.utils.helper.UtilText;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Scope;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

import static co.edu.uco.core.CrosswordsConstant.SINGLETON_SCOPE;

@Component
@Scope(SINGLETON_SCOPE)
public final class DatabaseMessageCatalog extends MessageCatalog {

    private final IMongoRepository mongoRepository;
    private final RedisTemplate<String, Message> redisTemplate;

    public DatabaseMessageCatalog(IMongoRepository mongoRepository, RedisTemplate<String, Message> redisTemplate) {
        this.mongoRepository = mongoRepository;
        this.redisTemplate = redisTemplate;
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
    public String getContent(String code) {
        try {
            return mongoRepository.findByCode(code)
                    .map(message -> {
                        redisTemplate.opsForValue().set(code, message);
                        return message.getContent();
                    })
                    .orElse(UtilText.EMPTY);
        } catch (CrossWordsException exception) {
            return UtilText.EMPTY;
        }
    }

    @Override
    public void addMessage(MessageKeyEnum key, MessageModel messageModel) {

    }

    @Override
    public boolean isExist(MessageKeyEnum key) {
        return false;
    }
}
