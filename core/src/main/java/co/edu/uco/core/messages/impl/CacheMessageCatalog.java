package co.edu.uco.core.messages.impl;

import co.edu.uco.core.domain.MessageRedis;
import co.edu.uco.core.messages.MessageCatalog;
import co.edu.uco.core.messages.MessageModel;
import co.edu.uco.core.messages.enums.MessageKeyEnum;
import co.edu.uco.utils.helper.UtilText;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Objects;

import static co.edu.uco.core.CrosswordsConstant.SINGLETON_SCOPE;

@Component
@Scope(SINGLETON_SCOPE)
public final class CacheMessageCatalog extends MessageCatalog {

    private final RedisTemplate<String, MessageRedis> template;

    @Autowired
    public CacheMessageCatalog(RedisTemplate<String, MessageRedis> template) {
        this.template = template;
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
        MessageRedis cachedMessage = template.opsForValue().get(code);
        if (Objects.nonNull(cachedMessage)) {
            return cachedMessage.getContent().concat(" Consult with cache");
        } else {
            return UtilText.EMPTY;
        }
    }

    @Override
    public void addMessage(MessageKeyEnum key, MessageModel messageModel) {}

    @Override
    public boolean isExist(MessageKeyEnum key) {
        return false;
    }
}