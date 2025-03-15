package co.edu.uco.core.application.catalog.strategy;

import co.edu.uco.core.application.catalog.strategy.cache.CacheCatalog;
import co.edu.uco.core.application.catalog.strategy.database.DatabaseCatalog;
import co.edu.uco.core.domain.data.MessageData;
import co.edu.uco.core.domain.port.out.repository.SimplePage;
import co.edu.uco.core.domain.port.out.repository.SimplePageRequest;
import co.edu.uco.core.application.catalog.strategy.inmemory.InMemoryCatalog;
import co.edu.uco.utils.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static co.edu.uco.core.CrosswordsConstant.SINGLETON_SCOPE;
import static co.edu.uco.core.application.catalog.strategy.inmemory.enums.MessageKeyEnum.*;

@Component
@Scope(SINGLETON_SCOPE)
public final class MessageCatalogStrategy {
    private static final Logger log = LoggerFactory.getLogger(MessageCatalogStrategy.class);
    private final CacheCatalog cacheCatalog;
    private final DatabaseCatalog databaseCatalog;
    private final InMemoryCatalog inMemoryCatalog;

    public MessageCatalogStrategy(CacheCatalog cacheCatalog, DatabaseCatalog databaseCatalog,
            InMemoryCatalog inMemoryCatalog) {
        this.cacheCatalog = cacheCatalog;
        this.databaseCatalog = databaseCatalog;
        this.inMemoryCatalog = inMemoryCatalog;
    }

    public MessageData getMessage(String code, String application) {
        var response = cacheCatalog.getMessage(code, application);
        if (response.isEmpty()) {
            log.warn(inMemoryCatalog.getContent(FUN_006.getKey()));
            response = databaseCatalog.getMessage(code, application);
            response.ifPresent(cacheCatalog::addMessage);
        }
        return response
                .orElseThrow(() -> BusinessException.buildUserException(inMemoryCatalog.getContent(TCH_009.getKey())));
    }

    public SimplePage<MessageData> getMessages(String application, SimplePageRequest request) {
        var cachedMessages = cacheCatalog.getMessage(application, request);
        if (cachedMessages.getData().isEmpty()) {
            log.info(inMemoryCatalog.getContent(FUN_006.getKey()));
            var dbMessages = databaseCatalog.getMessage(application, request);
            if (!dbMessages.getData().isEmpty()) {
                log.info(inMemoryCatalog.getContent(FUN_007.getKey()));
                fillCacheWithMissingMessages(cachedMessages, dbMessages);
                return dbMessages;
            }
            throw BusinessException.buildUserException(inMemoryCatalog.getContent(TCH_009.getKey()));
        }

        var dbMessages = databaseCatalog.getMessage(application, request);
        if (!dbMessages.getData().isEmpty()) {
            if (cachedMessages.getData().size() != dbMessages.getData().size()) {
                log.info(inMemoryCatalog.getContent(FUN_008.getKey()));
                fillCacheWithMissingMessages(cachedMessages, dbMessages);
                return dbMessages;
            }
            log.info(inMemoryCatalog.getContent(FUN_009.getKey()));
            return cachedMessages;
        }
        throw BusinessException.buildUserException(inMemoryCatalog.getContent(TCH_009.getKey()));
    }

    public SimplePage<MessageData> getMessagesWithEnvironment(String environment, SimplePageRequest request) {
        var cachedMessages = cacheCatalog.getMessageWithEnvironment(environment, request);
        if (cachedMessages.getData().isEmpty()) {
            log.info(inMemoryCatalog.getContent(FUN_006.getKey()));
            var dbMessages = databaseCatalog.getMessageWithEnvironment(environment, request);
            if (!dbMessages.getData().isEmpty()) {
                log.info(inMemoryCatalog.getContent(FUN_007.getKey()));
                fillCacheWithEnvironmentMessages(cachedMessages, dbMessages, environment);
                return dbMessages;
            }
            throw BusinessException.buildUserException(inMemoryCatalog.getContent(TCH_009.getKey()));
        }

        var dbMessages = databaseCatalog.getMessageWithEnvironment(environment, request);
        if (!dbMessages.getData().isEmpty()) {
            if (cachedMessages.getData().size() != dbMessages.getData().size()) {
                log.info(inMemoryCatalog.getContent(FUN_008.getKey()));
                fillCacheWithEnvironmentMessages(cachedMessages, dbMessages, environment);
                return dbMessages;
            }
            log.info(inMemoryCatalog.getContent(FUN_009.getKey()));
            return cachedMessages;
        }
        throw BusinessException.buildUserException(inMemoryCatalog.getContent(TCH_009.getKey()));
    }

    private void fillCacheWithMissingMessages(SimplePage<MessageData> cachedMessages,
            SimplePage<MessageData> dbMessages) {
        dbMessages.getData().forEach(cacheCatalog::addMessage);
    }

    private void fillCacheWithEnvironmentMessages(SimplePage<MessageData> cachedMessages,
            SimplePage<MessageData> dbMessages, String environment) {
        dbMessages.getData().forEach(message -> cacheCatalog.addMessageWithEnvironment(message, environment));
    }
}