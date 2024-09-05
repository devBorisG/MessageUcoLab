package co.edu.uco.core.domain.usecase;

import co.edu.uco.core.application.dto.MessageCodeDTO;
import co.edu.uco.core.assembler.pojo.Message;
import co.edu.uco.core.domain.domains.MessageCodeDomain;
import co.edu.uco.core.domain.port.in.ListMessageCacheInPort;
import co.edu.uco.core.domain.port.out.db.mongo.IMongoRepository;
import co.edu.uco.core.domain.port.out.db.redis.RedisMessage;
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
    private final RedisMessage redisRepository;
    private final RedisTemplate<String, Message> redisTemplate;

    @Autowired
    public ListMessageCacheUseCase(ListMessagePresenter presenter, IMongoRepository mongoRepository, RedisMessage redisRepository, RedisTemplate<String, Message> redisTemplate) {
        this.presenter = presenter;
        this.mongoRepository = mongoRepository;
        this.redisRepository = redisRepository;
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void execute(MessageCodeDomain entity, HttpServletResponse response) {
        Message message = new Message();
        message.setCode("1");
        message.setContent("Hello World");
        message.setApplication("AAplication");
        message.setStatus("Active");
        message.setFunctionality("Functionality");
        message.setType("Type");
        message.setTitle("Title");
        message.setId("098");
        try {
            //log.info(Objects.requireNonNull(redisTemplate.opsForValue().get("message:125")).getContent());
            if (redisTemplate.opsForValue().get(entity.getCode()) != null) {
                log.info((Objects.requireNonNull(redisTemplate.opsForValue().get(entity.getCode())).getContent()));
            } else {
                mongoRepository.findAllSelf(entity.getCode()).forEach(message1 -> {
                    redisTemplate.opsForValue().set("message:126", message1);
                    log.info(message1.getContent());
                });
            }
        } catch (Exception exception) {
            System.out.println("Error: " + exception.getMessage());
        }
    }
}
