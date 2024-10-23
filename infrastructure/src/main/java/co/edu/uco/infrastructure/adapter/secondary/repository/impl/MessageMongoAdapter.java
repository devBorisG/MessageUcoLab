package co.edu.uco.infrastructure.adapter.secondary.repository.impl;

import co.edu.uco.core.domain.data.MessageData;
import co.edu.uco.core.domain.port.out.repository.MessageRepository;
import co.edu.uco.infrastructure.adapter.secondary.repository.mongo.IMongoRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component("MongoAdapter")
public final class MessageMongoAdapter implements MessageRepository {
    private final IMongoRepository repository;
    public MessageMongoAdapter(IMongoRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(MessageData data) {

    }

    @Override
    public Optional<MessageData> findApplicationMessageByCode(String code) {
        return Optional.empty();
    }

    @Override
    public List<MessageData> finByApplication(String application) {
        return new ArrayList<>();
    }
}