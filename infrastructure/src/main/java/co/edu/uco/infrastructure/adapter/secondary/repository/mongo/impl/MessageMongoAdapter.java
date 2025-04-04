package co.edu.uco.infrastructure.adapter.secondary.repository.mongo.impl;

import co.edu.uco.core.domain.data.MessageData;
import co.edu.uco.core.domain.port.out.repository.DataBaseMessageRepository;
import co.edu.uco.core.domain.port.out.repository.SimplePage;
import co.edu.uco.infrastructure.adapter.secondary.repository.data.DataMapper;
import co.edu.uco.infrastructure.adapter.secondary.repository.mongo.MongoEnvironmentRepositoryAdapter;
import co.edu.uco.infrastructure.adapter.secondary.repository.mongo.model.MessageEnvironmentDocument;
import co.edu.uco.infrastructure.adapter.secondary.repository.mongo.model.MessageDocument;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static co.edu.uco.infrastructure.configuration.InfrastructureConstant.DATABASE_MONGO_ADAPTER;

@Component(DATABASE_MONGO_ADAPTER)
public final class MessageMongoAdapter implements DataBaseMessageRepository {
    private final MongoEnvironmentRepositoryAdapter environmentRepository;
    private final DataMapper<MessageData, MessageDocument> mapperJson;
    public MessageMongoAdapter(
            MongoEnvironmentRepositoryAdapter environmentRepository,
            DataMapper<MessageData, MessageDocument> mapperJson) {
        this.environmentRepository = environmentRepository;
        this.mapperJson = mapperJson;
    }
    @Override
    public void save(MessageData data) {
    }
    @Override
    public Optional<MessageData> findApplicationMessageByCode(String code, String application) {
        return Optional.empty();
    }
    @Override
    public SimplePage<MessageData> finByApplication(String application, Pageable pageable) {
        return null;
    }
    @Override
    public List<MessageData> finByApplication(String application) {
        return List.of();
    }
    @Override
    public Optional<MessageData> findById(UUID id) {
       return Optional.empty();
    }
    @Override
    public SimplePage<MessageData> findMessagesByEnvironment(String id, Pageable pageable) {
        Page<MessageEnvironmentDocument> query = environmentRepository.findMessageEnvironmentDocumentByEnvironmentId(id,
                pageable);
        Page<MessageData> messageDataPage = query.map(doc -> mapperJson.mapperData(doc.getMessage()));
        return SimplePage.of(messageDataPage);
    }
    @Override
    public Optional<MessageData> findMessageByCodeAndEnvironment(String code, String environmentId) {
        return environmentRepository.findByEnvironmentIdAndMessageCode(environmentId, code)
                .map(doc -> mapperJson.mapperData(doc.getMessage()));
    }
}