package co.edu.uco.infrastructure.adapter.secondary.repository.redis.impl;

import co.edu.uco.core.domain.data.MessageData;
import co.edu.uco.core.domain.port.out.repository.CacheMessageRepository;
import co.edu.uco.core.domain.port.out.repository.MessageRepository;
import co.edu.uco.infrastructure.adapter.secondary.repository.data.DataMapper;
import co.edu.uco.infrastructure.adapter.secondary.repository.redis.MessageRedis;
import co.edu.uco.infrastructure.adapter.secondary.repository.redis.RedisRepositoryAdapter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component("MessageRedisAdapter")
public final class MessageRedisAdapter implements CacheMessageRepository {
    private final RedisRepositoryAdapter repository;
    private final DataMapper<MessageData, MessageRedis> mapper;

    public MessageRedisAdapter(RedisRepositoryAdapter repository, DataMapper<MessageData, MessageRedis> mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }
    @Override
    public void save(MessageData data) {
        repository.save(mapper.assemblerModel(data));
    }
    @Override
    public Optional<MessageData> findApplicationMessageByCode(String code, String application) {
        return repository.findByApplicationAndCode(application, code).stream().map(mapper::assemblerData).findFirst();
    }
    @Override
    public List<MessageData> finByApplication(String application) {
        return repository.findByApplication(application).stream().map(mapper::assemblerData).toList();
    }
}