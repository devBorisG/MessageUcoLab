package co.edu.uco.core.domain.usecase;

import co.edu.uco.core.application.dto.MessageCodeDTO;
import co.edu.uco.core.domain.MessageRedis;
import co.edu.uco.core.domain.domains.MessageCodeDomain;
import co.edu.uco.core.domain.port.in.ListMessageCacheInPort;
import co.edu.uco.core.domain.port.out.db.mongo.IMongoRepository;
import co.edu.uco.core.domain.port.out.presenter.ListMessagePresenter;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Slf4j
public class ListMessageCacheUseCase implements ListMessageCacheInPort {

    private final ListMessagePresenter presenter;
    private final IMongoRepository mongoRepository;
    private final RedisTemplate<String, MessageRedis> redisTemplate;
    private String message;

    @Autowired
    public ListMessageCacheUseCase(ListMessagePresenter presenter, IMongoRepository mongoRepository, RedisTemplate<String, MessageRedis> redisTemplate) {
        this.presenter = presenter;
        this.mongoRepository = mongoRepository;
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void execute(MessageCodeDomain entity, HttpServletResponse response) {
        try {
            if (redisTemplate.opsForValue().get(entity.getCode()) != null) {
                log.info((Objects.requireNonNull(redisTemplate.opsForValue().get(entity.getCode())).getContent()));
                message = "Por redis " + Objects.requireNonNull(redisTemplate.opsForValue().get(entity.getCode())).getContent();
            }
            presenter.execute(MessageCodeDTO.create(message), response);
        } catch (Exception exception) {
            log.error("Error: {}", exception.getMessage());
        }
    }
}
