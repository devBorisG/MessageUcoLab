package co.edu.uco.infrastructure.adapter.secondary.repository.data;

import co.edu.uco.core.domain.data.MessageEnvironmentData;
import co.edu.uco.infrastructure.adapter.secondary.repository.mongo.model.MessageEnvironmentDocument;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static co.edu.uco.core.CrosswordsConstant.SINGLETON_SCOPE;

@Component
@Scope(SINGLETON_SCOPE)
public class MessageEnvironmentMapper implements DataMapper<MessageEnvironmentData, MessageEnvironmentDocument> {
    private final ModelMapper modelMapper;

    public MessageEnvironmentMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public MessageEnvironmentData mapperData(MessageEnvironmentDocument model) {
        return modelMapper.map(model, MessageEnvironmentData.class);
    }

    @Override
    public MessageEnvironmentDocument mapperModel(MessageEnvironmentData data) {
        return modelMapper.map(data, MessageEnvironmentDocument.class);
    }
}
