package co.edu.uco.infrastructure.adapter.secondary.repository.redis;

import co.edu.uco.infrastructure.adapter.secondary.repository.MessageRedis;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RedisMessage extends CrudRepository<MessageRedis, String> {
    Optional<MessageRedis> findByCode(String s);
}
