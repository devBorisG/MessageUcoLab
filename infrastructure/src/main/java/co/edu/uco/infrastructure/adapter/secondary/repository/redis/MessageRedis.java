package co.edu.uco.infrastructure.adapter.secondary.repository.redis;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.util.UUID;

import static co.edu.uco.infrastructure.configuration.InfrastructureConstant.REDIS_HASH;

@Getter
@Setter
@RedisHash(REDIS_HASH)
public final class MessageRedis {
    @Id
    private UUID id;
    @Indexed
    private String code;
    private String title;
    private String content;
    private String type;
    private String category;
    private String status;
    @Indexed
    private String application;
    private String functionality;
}