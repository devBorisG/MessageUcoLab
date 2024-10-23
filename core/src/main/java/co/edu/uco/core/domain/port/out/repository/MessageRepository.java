package co.edu.uco.core.domain.port.out.repository;

import co.edu.uco.core.domain.data.MessageData;

import java.util.List;
import java.util.Optional;

public interface MessageRepository {
    void save(MessageData data);
    Optional<MessageData> findApplicationMessageByCode(String code);
    List<MessageData> finByApplication(String application);
}