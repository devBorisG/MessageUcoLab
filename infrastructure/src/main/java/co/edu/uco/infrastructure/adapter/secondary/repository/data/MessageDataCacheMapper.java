package co.edu.uco.infrastructure.adapter.secondary.repository.data;

import co.edu.uco.core.domain.data.MessageData;
import co.edu.uco.infrastructure.adapter.secondary.repository.redis.MessageRedis;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static co.edu.uco.core.CrosswordsConstant.SINGLETON_SCOPE;

@Component
@Scope(SINGLETON_SCOPE)
public final class MessageDataCacheMapper  implements DataMapper<MessageData, MessageRedis>{
    private  final ModelMapper modelMapper;
    public MessageDataCacheMapper(ModelMapper modelMapper) {this.modelMapper = modelMapper;}
    @Override
    public MessageData assemblerData(MessageRedis model) {
        return modelMapper.map(model, MessageData.class);
    }
    @Override
    public MessageRedis assemblerModel(MessageData data) {
        return modelMapper.map(data, MessageRedis.class);
    }
}