package co.edu.uco.core.domain.usecase;

import co.edu.uco.core.application.dto.MessageCodeDTO;
import co.edu.uco.core.assembler.pojo.Message;
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
    private final RedisTemplate<String, Message> redisTemplate;
    private String message;

    @Autowired
    public ListMessageCacheUseCase(ListMessagePresenter presenter, IMongoRepository mongoRepository, RedisTemplate<String, Message> redisTemplate) {
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
            } else {
                mongoRepository.findAllSelf(entity.getCode()).forEach(message1 -> {
                    redisTemplate.opsForValue().set("message:126", message1);
                    log.info(message1.getContent());
                    message = "Por mongo " + message1.getContent();
                });
            }
            presenter.execute(MessageCodeDTO.create(message), response);
        } catch (Exception exception) {
            System.out.println("Error: " + exception.getMessage());
        }
    }
}
