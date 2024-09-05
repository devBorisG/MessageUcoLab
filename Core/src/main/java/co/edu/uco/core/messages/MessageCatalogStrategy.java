package co.edu.uco.core.messages;

import co.edu.uco.core.messages.impl.CacheMessageCatalog;
import co.edu.uco.core.messages.impl.DatabaseMessageCatalog;
import co.edu.uco.core.messages.impl.InMemoryMessageCatalog;
import co.edu.uco.core.messages.properties.MessagesPropertiesCatalog;
import co.edu.uco.utils.exception.CrossWordsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

import static co.edu.uco.utils.helper.UtilObject.isNullObject;
import static co.edu.uco.utils.helper.UtilText.EMPTY;

@Component
@Scope("singleton")
public final class MessageCatalogStrategy {
    private final List<MessageCatalog> catalogs;

    @Autowired
    public MessageCatalogStrategy(MessagesPropertiesCatalog messagesPropertiesCatalog,
                                  DatabaseMessageCatalog databaseMessageCatalog,
                                  CacheMessageCatalog cacheMessageCatalog,
                                 InMemoryMessageCatalog inMemoryMessageCatalog) {
        this.catalogs = Arrays.asList(messagesPropertiesCatalog, cacheMessageCatalog, databaseMessageCatalog);
    }

    public String getMessage(final MessageCatalogEnum key) {
        if (isNullObject(key)) {
            throw CrossWordsException.build(getMessage(MessageCatalogEnum.TCH_007));
        }
        var message = EMPTY;
        for (var catalog : catalogs) {
            message = catalog.getContent(key);
            if (catalog.isExist(key)) {
                return message;
            }
        }
        return message;
    }
}