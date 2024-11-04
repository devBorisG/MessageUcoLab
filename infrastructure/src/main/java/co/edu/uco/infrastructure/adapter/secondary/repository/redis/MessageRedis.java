package co.edu.uco.infrastructure.adapter.secondary.repository.redis;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;

import java.util.UUID;

@Getter
@Setter
@RedisHash("Message")
public final class MessageRedis {
    @Id
    private UUID id;
    private String code;
    private String title;
    private String content;
    private String type;
    private String category;
    private String status;
    private String application;
    private String functionality;
}