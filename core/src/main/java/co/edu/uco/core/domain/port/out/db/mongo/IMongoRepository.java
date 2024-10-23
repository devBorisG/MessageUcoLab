package co.edu.uco.core.domain.port.out.db.mongo;

import co.edu.uco.core.domain.MessageDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface IMongoRepository extends MongoRepository<MessageDocument, String> {
    @Query(value = "{'_airbyte_data.code': ?0}")
    Optional<MessageDocument> findByCode(String code);
}