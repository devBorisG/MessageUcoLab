package co.edu.uco.core.messages.impl;

import co.edu.uco.core.CrosswordsConstant;
import co.edu.uco.core.messages.MessageModel;
import co.edu.uco.core.messages.MessageCatalog;
import co.edu.uco.core.messages.enums.MessageKeyEnum;
import co.edu.uco.core.messages.enums.DetailMessageEnum;
import co.edu.uco.utils.exception.CrossWordsException;
import co.edu.uco.utils.helper.UtilObject;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Scope(CrosswordsConstant.SINGLETON_SCOPE)
public final class InMemoryMessageCatalog extends MessageCatalog {
    private Map<MessageKeyEnum, MessageModel> messages;
    @Override
    @PostConstruct
    public void loadCatalog() {
        messages = UtilObject.getDefaultIsNullObject(messages, new HashMap<>());
        for (var messageEnum : DetailMessageEnum.values()) {
            messages.put(messageEnum.getCode(), messageEnum.getMessage());
        }
    }

    @Override
    public void reloadCatalog() {
        messages.clear();
        loadCatalog();
    }

    @Override
    public MessageModel getMessage(MessageKeyEnum code) {
        if (UtilObject.isNullObject(code)) {
            throw CrossWordsException.build(getContent(String.valueOf(MessageKeyEnum.TCH_007)));
        }
        return messages.get(code);
    }

    @Override
    public String getContent(String code) {
        if (UtilObject.isNullObject(code)) {
            throw CrossWordsException.build(getContent(String.valueOf(MessageKeyEnum.TCH_007)));
        }
        return messages.get(MessageKeyEnum.of(code)).content();
    }

    @Override
    public void addMessage(MessageKeyEnum key, MessageModel messageModel) {
        messages.put(key, messageModel);
    }

    @Override
    public boolean isExist(MessageKeyEnum key) {
        return messages.containsKey(key);
    }
}
