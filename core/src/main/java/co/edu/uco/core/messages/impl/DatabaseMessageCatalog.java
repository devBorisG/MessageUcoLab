package co.edu.uco.core.messages.impl;

import co.edu.uco.core.assembler.data.MessageMapper;
import co.edu.uco.core.domain.MessageRedis;
import co.edu.uco.core.domain.port.out.db.mongo.IMongoRepository;
import co.edu.uco.core.messages.MessageModel;
import co.edu.uco.core.messages.MessageCatalog;
import co.edu.uco.core.messages.enums.MessageKeyEnum;
import org.springframework.context.annotation.Scope;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import static co.edu.uco.utils.helper.UtilText.EMPTY;
import static co.edu.uco.core.CrosswordsConstant.SINGLETON_SCOPE;

@Component
@Scope(SINGLETON_SCOPE)
public final class DatabaseMessageCatalog extends MessageCatalog {

    private final IMongoRepository mongoRepository;
    private final MessageMapper messageMapper;
    private final RedisTemplate<String, MessageRedis> redisTemplate;

    public DatabaseMessageCatalog(IMongoRepository mongoRepository, MessageMapper messageMapper, RedisTemplate<String, MessageRedis> redisTemplate) {
        this.mongoRepository = mongoRepository;
        this.messageMapper = messageMapper;
        this.redisTemplate = redisTemplate;
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
        return mongoRepository.findByCode(code)
                .map(messageDocument -> {
                    redisTemplate.opsForValue().set(code, messageMapper.toRedis(messageDocument));
                    return messageDocument.getContent();
                })
                .orElse(EMPTY);
    }

    @Override
    public void addMessage(MessageKeyEnum key, MessageModel messageModel) {

    }

    @Override
    public boolean isExist(MessageKeyEnum key) {
        return false;
    }
}
