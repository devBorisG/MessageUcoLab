package co.edu.uco.core.domain.port.out.repository;

import co.edu.uco.core.domain.data.MessageData;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface MessageRepository {
    void save(MessageData data);
    Optional<MessageData> findApplicationMessageByCode(String code,String application);
    SimplePage<MessageData> finByApplication(String application, Pageable pageable);
    List<MessageData> finByApplication(String application);
}