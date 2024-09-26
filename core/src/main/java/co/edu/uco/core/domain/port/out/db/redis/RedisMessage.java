package co.edu.uco.core.domain.port.out.db.redis;

import co.edu.uco.core.domain.MessageRedis;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RedisMessage extends CrudRepository<MessageRedis, String> {
    Optional<MessageRedis> findByCode(String s);
}
