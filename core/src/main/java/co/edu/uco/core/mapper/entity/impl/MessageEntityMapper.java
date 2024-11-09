package co.edu.uco.core.mapper.entity.impl;

import co.edu.uco.core.mapper.entity.EntityMapper;
import co.edu.uco.core.domain.domains.MessageDomain;
import co.edu.uco.core.domain.aggregate.entities.MessageEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class MessageEntityMapper implements EntityMapper<MessageEntity, MessageDomain> {
    private final ModelMapper mapper;
    public MessageEntityMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }
    @Override
    public MessageDomain mapperDomain(MessageEntity entity) {
        return mapper.map(entity, MessageDomain.class);
    }
    @Override
    public MessageEntity mapperEntity(MessageDomain domain) {
        return mapper.map(domain, MessageEntity.class);
    }
}