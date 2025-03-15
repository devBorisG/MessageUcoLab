package co.edu.uco.infrastructure.adapter.secondary.repository.redis.impl;

import co.edu.uco.core.domain.data.MessageData;
import co.edu.uco.core.domain.port.out.repository.CacheMessageRepository;
import co.edu.uco.core.domain.port.out.repository.SimplePage;
import co.edu.uco.infrastructure.adapter.secondary.repository.data.DataMapper;
import co.edu.uco.infrastructure.adapter.secondary.repository.redis.MessageRedis;
import co.edu.uco.infrastructure.adapter.secondary.repository.redis.RedisRepositoryAdapter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static co.edu.uco.infrastructure.configuration.InfrastructureConstant.CACHE_REDIS_ADAPTER;

@Component(CACHE_REDIS_ADAPTER)
public final class MessageRedisAdapter implements CacheMessageRepository {
    private final RedisRepositoryAdapter repository;
    private final DataMapper<MessageData, MessageRedis> mapper;

    public MessageRedisAdapter(RedisRepositoryAdapter repository, DataMapper<MessageData, MessageRedis> mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public void save(MessageData data) {
        repository.save(mapper.mapperModel(data));
    }

    @Override
    public Optional<MessageData> findApplicationMessageByCode(String code, String application) {
        return repository.findByCodeAndApplication(code, application).stream().map(mapper::mapperData).findFirst();
    }

    @Override
    public SimplePage<MessageData> finByApplication(String application, Pageable pageable) {
        return SimplePage.of(repository.findByApplication(application, pageable).map(mapper::mapperData));
    }

    @Override
    public List<MessageData> finByApplication(String application) {
        return repository.findByApplication(application).stream().map(mapper::mapperData).toList();
    }

    @Override
    public Optional<MessageData> findById(UUID id) {
        return repository.findById(id).map(mapper::mapperData);
    }

    @Override
    public SimplePage<MessageData> findByIdEnvironment(UUID id, Pageable pageable) {
        return SimplePage.of(Page.empty());
    }

    @Override
    public SimplePage<MessageData> findMessagesByEnvironment(String environment, Pageable pageable) {
        return SimplePage.of(Page.empty());
    }
}