package co.edu.uco.core.domain.port.out.repository;

import co.edu.uco.core.domain.data.MessageData;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MessageRepository {
    void save(MessageData data);
    Optional<MessageData> findApplicationMessageByCode(String code,String application);
    SimplePage<MessageData> finByApplication(String application, Pageable pageable);
    List<MessageData> finByApplication(String application);
    Optional<MessageData> findById(UUID id);
    SimplePage<MessageData> findByIdEnvironment(UUID id, Pageable pageable);
    SimplePage<MessageData> findMessagesByEnvironment(String id, Pageable pageable);
}