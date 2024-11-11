package co.edu.uco.core.message.strategy;

import co.edu.uco.core.domain.data.MessageData;
import co.edu.uco.core.domain.port.out.repository.SimplePage;
import co.edu.uco.core.domain.port.out.repository.SimplePageRequest;
import co.edu.uco.core.message.strategy.cache.CacheCatalog;
import co.edu.uco.core.message.strategy.database.DatabaseCatalog;
import co.edu.uco.core.message.strategy.inmemory.InMemoryCatalog;
import co.edu.uco.utils.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static co.edu.uco.core.CrosswordsConstant.SINGLETON_SCOPE;
import static co.edu.uco.core.message.strategy.inmemory.enums.MessageKeyEnum.TCH_009;
import static co.edu.uco.utils.helper.UtilUUID.getStringFromUUID;

@Component
@Scope(SINGLETON_SCOPE)
public final class MessageCatalogStrategy {
    private static final Logger log = LoggerFactory.getLogger(MessageCatalogStrategy.class);
    private final CacheCatalog cacheCatalog;
    private final DatabaseCatalog databaseCatalog;
    private final InMemoryCatalog inMemoryCatalog;

    public MessageCatalogStrategy(CacheCatalog cacheCatalog, DatabaseCatalog databaseCatalog, InMemoryCatalog inMemoryCatalog) {
        this.cacheCatalog = cacheCatalog;
        this.databaseCatalog = databaseCatalog;
        this.inMemoryCatalog = inMemoryCatalog;
    }

    public MessageData getMessage(String code, String application) {
        var response = cacheCatalog.getMessage(code, application);
        if (response.isEmpty()) {
            log.warn("No se encontro el mensaje en cache, se procede a buscar en base de datos");
            response = databaseCatalog.getMessage(code, application);
            response.ifPresent(cacheCatalog::addMessage);
        }
        return response.orElseThrow(() -> BusinessException.buildUserException(inMemoryCatalog.getContent(TCH_009.getKey())));
    }

    public SimplePage<MessageData> getMessages(String application, SimplePageRequest request) {
        SimplePage<MessageData> cachedMessages = cacheCatalog.getMessage(application, request);

        if (!cachedMessages.getData().isEmpty()) {
            log.warn("Se encontraron mensajes en cache, se procede a retornar");
            return cachedMessages;
        }
        SimplePage<MessageData> dbMessages = databaseCatalog.getMessage(application, request);
        if (!dbMessages.getData().isEmpty()) {
            log.warn("Se encontraron mensajes en base de datos, se procede a retornar y guardar en cache");
            databaseCatalog.getMessages(application)
                    .forEach(cacheCatalog::addMessage);
            return dbMessages;
        }
        throw BusinessException.buildUserException(inMemoryCatalog.getContent(TCH_009.getKey()));
    }
}