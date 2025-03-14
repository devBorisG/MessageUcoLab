package co.edu.uco.infrastructure.adapter.secondary.repository.mongo;

import co.edu.uco.infrastructure.adapter.secondary.repository.mongo.model.MessageEnvironmentDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MongoEnvironmentRepositoryAdapter  extends MongoRepository<MessageEnvironmentDocument, String> {
    List<MessageEnvironmentDocument> findMessageEnvironmentDocumentByEnvironmentId(String environmentId);
}