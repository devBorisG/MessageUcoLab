package co.edu.uco.infrastructure.adapter.secondary.repository.mongo;

import co.edu.uco.infrastructure.adapter.secondary.repository.mongo.model.TokenDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TokenMongoRepositoryAdapter extends MongoRepository<TokenDocument, String> {
    @Query("select * from token where id = ?1")
    Optional<TokenDocument> findById(String id);
}