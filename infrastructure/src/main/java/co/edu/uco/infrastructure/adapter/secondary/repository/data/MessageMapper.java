package co.edu.uco.infrastructure.adapter.secondary.repository.data;

import co.edu.uco.infrastructure.adapter.secondary.repository.MessageDocument;
import co.edu.uco.infrastructure.adapter.secondary.repository.MessageRedis;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static co.edu.uco.core.CrosswordsConstant.SINGLETON_SCOPE;

@Component
@Scope(SINGLETON_SCOPE)
public final class MessageMapper {
    private  final ModelMapper modelMapper;
    public MessageMapper(ModelMapper modelMapper) {this.modelMapper = modelMapper;}
    public MessageRedis toRedis(MessageDocument mongoMessage) {
        return modelMapper.map(mongoMessage, MessageRedis.class);
    }
    public MessageDocument toMongo(MessageRedis redisMessage) {
        return modelMapper.map(redisMessage, MessageDocument.class);
    }
}