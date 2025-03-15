package co.edu.uco.core.domain.port.out.repository;

import co.edu.uco.core.domain.data.MessageData;

public interface CacheMessageRepository extends MessageRepository {
    void saveWithEnvironment(MessageData data, String environmentId);
}
