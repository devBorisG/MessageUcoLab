package co.edu.uco.core.domain.port.out.repository;

import co.edu.uco.core.domain.data.MessageData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface CacheMessageRepository extends MessageRepository {
    void saveWithEnvironment(MessageData data, String environmentId);

    Optional<MessageData> findMessageByCodeAndEnvironment(String code, String environmentId);

    SimplePage<MessageData> findByIdEnvironment(UUID id, Pageable pageable);
}
