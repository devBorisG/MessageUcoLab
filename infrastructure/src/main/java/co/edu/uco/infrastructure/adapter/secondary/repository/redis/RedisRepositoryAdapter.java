package co.edu.uco.infrastructure.adapter.secondary.repository.redis;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface RedisRepositoryAdapter extends JpaRepository<MessageRedis, UUID> {
    Optional<MessageRedis> findByCodeAndApplication(String code, String application);
    List<MessageRedis> findByApplication(String application);
}