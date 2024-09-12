package co.edu.uco.core.domain.port.out.db.mongo;

import co.edu.uco.core.assembler.pojo.Message;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface IMongoRepository extends MongoRepository<Message, String> {

    @Query(value="{code:'?0'}")
    List<Message> findAllSelf(String code);
}
