package co.edu.uco.core.messages.strategy;

import co.edu.uco.core.messages.MessageCatalog;
import co.edu.uco.core.messages.enums.MessageKeyEnum;
import co.edu.uco.core.messages.impl.CacheMessageCatalog;
import co.edu.uco.core.messages.impl.DatabaseMessageCatalog;
import co.edu.uco.core.messages.impl.InMemoryMessageCatalog;
import co.edu.uco.utils.exception.CrossWordsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

import static co.edu.uco.core.CrosswordsConstant.SINGLETON_SCOPE;
import static co.edu.uco.utils.helper.UtilObject.isNullObject;
import static co.edu.uco.utils.helper.UtilText.EMPTY;

@Component
@Scope(SINGLETON_SCOPE)
public final class MessageCatalogStrategy {
    private final List<MessageCatalog> catalogs;

    @Autowired
    public MessageCatalogStrategy(
                                  DatabaseMessageCatalog databaseMessageCatalog,
                                  CacheMessageCatalog cacheMessageCatalog,
                                 InMemoryMessageCatalog inMemoryMessageCatalog) {
        this.catalogs = Arrays.asList(cacheMessageCatalog, databaseMessageCatalog);
    }

    public String getMessage(final MessageKeyEnum key) {
        if (isNullObject(key)) {
            throw CrossWordsException.build(getMessage(MessageKeyEnum.TCH_007));
        }

        return catalogs.stream()
                .map(catalog -> catalog.getContent(key))
                .filter(content -> !content.equals(EMPTY))
                .findFirst()
                .orElse(EMPTY);
    }
}