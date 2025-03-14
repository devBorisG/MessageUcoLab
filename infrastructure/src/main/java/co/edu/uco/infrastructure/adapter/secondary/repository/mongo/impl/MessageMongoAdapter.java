package co.edu.uco.infrastructure.adapter.secondary.repository.mongo.impl;

import co.edu.uco.core.domain.data.MessageData;
import co.edu.uco.core.domain.data.MessageEnvironmentData;
import co.edu.uco.core.domain.port.out.repository.DataBaseMessageRepository;
import co.edu.uco.core.domain.port.out.repository.SimplePage;
import co.edu.uco.infrastructure.adapter.secondary.repository.data.DataMapper;
import co.edu.uco.infrastructure.adapter.secondary.repository.mongo.MongoEnvironmentRepositoryAdapter;
import co.edu.uco.infrastructure.adapter.secondary.repository.mongo.model.MessageDocument;
import co.edu.uco.infrastructure.adapter.secondary.repository.mongo.MongoRepositoryAdapter;
import co.edu.uco.infrastructure.adapter.secondary.repository.mongo.model.MessageEnvironmentDocument;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static co.edu.uco.infrastructure.configuration.InfrastructureConstant.DATABASE_MONGO_ADAPTER;
import static co.edu.uco.utils.helper.UtilUUID.getStringFromUUID;

@Component(DATABASE_MONGO_ADAPTER)
public final class MessageMongoAdapter implements DataBaseMessageRepository {
    private final MongoRepositoryAdapter repository;
    private final MongoEnvironmentRepositoryAdapter environmentRepository;
    private final DataMapper<MessageData, MessageDocument> mapper;
    private final DataMapper<MessageEnvironmentData, MessageEnvironmentDocument> environmentMapper;
    public MessageMongoAdapter(MongoRepositoryAdapter repository, MongoEnvironmentRepositoryAdapter environmentRepository, DataMapper<MessageData, MessageDocument> mapper,
                               DataMapper<MessageEnvironmentData, MessageEnvironmentDocument> environmentMapper) {
        this.repository = repository;
        this.environmentRepository = environmentRepository;
        this.mapper = mapper;
        this.environmentMapper = environmentMapper;
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

    @Override
    public Optional<MessageData> findById(UUID id) {
        return repository.findById(getStringFromUUID(id)).map(mapper::mapperData);
    }

    @Override
    public SimplePage<MessageData> findByIdEnvironment(UUID id, Pageable pageable) {
        return null/*SimplePage.of(environmentRepository.findMessageEnvironmentDocumentByEnvironmentId(getStringFromUUID(id), pageable))*/;
    }

    @Override
    public SimplePage<MessageData> findMessagesByEnvironment(String id, Pageable pageable) {
        var query = environmentRepository.findMessageEnvironmentDocumentByEnvironmentId(id);
        return null;
    }
}