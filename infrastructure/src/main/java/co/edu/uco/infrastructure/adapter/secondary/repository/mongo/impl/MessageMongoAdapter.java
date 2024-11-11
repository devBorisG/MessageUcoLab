package co.edu.uco.infrastructure.adapter.secondary.repository.mongo.impl;

import co.edu.uco.core.domain.data.MessageData;
import co.edu.uco.core.domain.port.out.repository.DataBaseMessageRepository;
import co.edu.uco.core.domain.port.out.repository.SimplePage;
import co.edu.uco.infrastructure.adapter.secondary.repository.data.DataMapper;
import co.edu.uco.infrastructure.adapter.secondary.repository.mongo.MessageDocument;
import co.edu.uco.infrastructure.adapter.secondary.repository.mongo.MongoRepositoryAdapter;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component("MessageMongoAdapter")
public final class MessageMongoAdapter implements DataBaseMessageRepository {
    private final MongoRepositoryAdapter repository;
    private final DataMapper<MessageData, MessageDocument> mapper;
    public MessageMongoAdapter(MongoRepositoryAdapter repository, DataMapper<MessageData, MessageDocument> mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }
    @Override
    public void save(MessageData data) {
        repository.save(mapper.mapperModel(data));
    }
    @Override
    public Optional<MessageData> findApplicationMessageByCode(String code, String application) {
        return repository.findByCodeAndApplication(code,application).stream().map(mapper::mapperData).findFirst();
    }

    @Override
    public SimplePage<MessageData> finByApplication(String application, Pageable pageable) {
        return SimplePage.of(repository.findByApplication(application, pageable).map(mapper::mapperData));
    }

    @Override
    public List<MessageData> finByApplication(String application) {
        return repository.findByApplication(application).stream().map(mapper::mapperData).toList();
    }
}