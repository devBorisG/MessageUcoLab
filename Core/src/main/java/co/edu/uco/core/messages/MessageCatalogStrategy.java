package co.edu.uco.core.messages;

import co.edu.uco.core.messages.impl.CacheMessageCatalog;
import co.edu.uco.core.messages.impl.DatabaseMessageCatalog;
import co.edu.uco.core.messages.properties.MessagesPropertiesCatalog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static co.edu.uco.utils.helper.UtilObject.isNullObject;

@Component
@Scope("singleton")
public class MessageCatalogStrategy {

    private final CacheMessageCatalog cacheMessageCatalog;
    private final DatabaseMessageCatalog databaseMessageCatalog;
    private MessageCatalog currentCatalog;

    @Autowired
    public MessageCatalogStrategy(MessagesPropertiesCatalog messagesPropertiesCatalog,
                                  DatabaseMessageCatalog databaseMessageCatalog,
                                  CacheMessageCatalog cacheMessageCatalog) {
        this.currentCatalog = messagesPropertiesCatalog;
        this.cacheMessageCatalog = cacheMessageCatalog;
        this.databaseMessageCatalog = databaseMessageCatalog;
    }

    private void setStrategy(MessageCatalog catalog) {
        this.currentCatalog = catalog;
    }

    public String getMessage(String key) {
        var message = currentCatalog.getMessage(key);
        if (isNullObject(message)) {
            setStrategy(cacheMessageCatalog);
            message = currentCatalog.getMessage(key);
            if (isNullObject(message)) {
                setStrategy(databaseMessageCatalog);
                message = currentCatalog.getMessage(key);
            }
        }
        return message;
    }

    public void addMessage(String key, String message) {
        currentCatalog.addMessage(key, message);
    }

    public boolean isExist(String key) {
        return currentCatalog.isExist(key);
    }
}