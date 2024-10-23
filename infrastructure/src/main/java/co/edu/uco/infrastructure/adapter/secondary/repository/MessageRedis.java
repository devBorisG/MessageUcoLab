package co.edu.uco.infrastructure.adapter.secondary.repository;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;

@Getter
@Setter
@RedisHash("0")
public final class MessageRedis {
    @Id
    private String id;
    private String code;
    private String title;
    private String content;
    private String type;
    private String category;
    private String status;
    private String application;
    private String functionality;
}