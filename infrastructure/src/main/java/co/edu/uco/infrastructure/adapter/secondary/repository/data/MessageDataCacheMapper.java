package co.edu.uco.infrastructure.adapter.secondary.repository.data;

import co.edu.uco.core.domain.data.MessageCategoryData;
import co.edu.uco.core.domain.data.MessageData;
import co.edu.uco.core.domain.data.MessageTypeData;
import co.edu.uco.infrastructure.adapter.secondary.repository.redis.MessageRedis;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static co.edu.uco.core.CrosswordsConstant.SINGLETON_SCOPE;

@Component
@Scope(SINGLETON_SCOPE)
public final class MessageDataCacheMapper implements DataMapper<MessageData, MessageRedis> {
    private final ModelMapper modelMapper;

    public MessageDataCacheMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public MessageData mapperData(MessageRedis model) {
        return new MessageData(model.getId(), model.getCode(), model.getTitle(), model.getContent(),
                MessageTypeData.build(),
                MessageCategoryData.build(), model.getApplication(), model.getFunctionality());
    }

    @Override
    public MessageRedis mapperModel(MessageData data) {
        return new MessageRedis(data.getId(), data.getCode(), data.getTitle(), data.getContent(),
                data.getType().getName(),
                data.getCategory().getName(), data.getStatus().getName(), data.getApplication(),
                data.getFunctionality());
    }
}