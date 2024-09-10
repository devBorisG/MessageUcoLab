package co.edu.uco.core.assembler.entity.impl;

import co.edu.uco.core.assembler.entity.EntityAssembler;
import co.edu.uco.core.domain.domains.MessageDomain;
import co.edu.uco.core.domain.aggregate.entities.MessageEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class MessageEntityAssembler implements EntityAssembler<MessageEntity, MessageDomain> {

    private final ModelMapper mapper;

    public MessageEntityAssembler(ModelMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public MessageDomain assembleDomain(MessageEntity entity) {
        return mapper.map(entity, MessageDomain.class);
    }

    @Override
    public MessageEntity assembleEntity(MessageDomain domain) {
        return mapper.map(domain, MessageEntity.class);
    }
}
