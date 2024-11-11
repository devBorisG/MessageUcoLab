package co.edu.uco.infrastructure.adapter.secondary.repository.mongo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MongoRepositoryAdapter extends MongoRepository<MessageDocument, String> {
    Optional<MessageDocument> findByCodeAndApplication(String code, String application);
    Page<MessageDocument> findByApplication(String application, Pageable pageable);
    List<MessageDocument> findByApplication(String application);
}