package co.edu.uco.infrastructure.adapter.secondary.repository.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MongoRepositoryAdapter extends MongoRepository<MessageDocument, String> {
    List<MessageDocument> findByApplication(String application);
    Optional<MessageDocument> findByCodeAndApplication(String code, String application);
}