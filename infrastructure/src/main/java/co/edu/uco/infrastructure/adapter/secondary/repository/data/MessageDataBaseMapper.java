package co.edu.uco.infrastructure.adapter.secondary.repository.data;

import co.edu.uco.core.domain.data.MessageData;
import co.edu.uco.infrastructure.adapter.secondary.repository.mongo.model.MessageJsonDocument;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static co.edu.uco.core.CrosswordsConstant.SINGLETON_SCOPE;

@Component
@Scope(SINGLETON_SCOPE)
public final class MessageDataBaseMapper implements DataMapper<MessageData, MessageJsonDocument> {
    private final ModelMapper modelMapper;

    public MessageDataBaseMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public MessageData mapperData(MessageJsonDocument model) {
        return modelMapper.map(model, MessageData.class);
    }

    @Override
    public MessageJsonDocument mapperModel(MessageData data) {
        return modelMapper.map(data, MessageJsonDocument.class);
    }
}