package co.edu.uco.infrastructure.adapter.secondary.repository.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MongoRepositoryAdapter extends MongoRepository<MessageDocument, String> {
    @Query(value = "{'_airbyte_data.code': ?0}")
    Optional<MessageDocument> findByApplication(String code);
    @Query("{'_airbyte_data.application': ?0, '_airbyte_data.code': ?1}")
    List<MessageDocument> findByApplicationAndCode(String application, String code);
}