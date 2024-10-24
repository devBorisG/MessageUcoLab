package co.edu.uco.infrastructure.adapter.secondary.repository.redis;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RedisRepositoryAdapter extends CrudRepository<MessageRedis, String> {
    Optional<MessageRedis> findByApplicationAndCode(String application, String code);
    List<MessageRedis> findByApplication(String application);
}