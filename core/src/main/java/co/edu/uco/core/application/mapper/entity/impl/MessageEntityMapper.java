package co.edu.uco.core.application.mapper.entity.impl;

import co.edu.uco.core.application.dto.MessageDTO;
import co.edu.uco.core.domain.data.MessageData;
import co.edu.uco.core.application.mapper.entity.EntityMapper;
import co.edu.uco.core.domain.domains.MessageDomain;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class MessageEntityMapper implements EntityMapper<MessageData, MessageDomain, MessageDTO> {
    private final ModelMapper mapper;
    public MessageEntityMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }
    @Override
    public MessageDomain mapperDomain(MessageData entity) {
        return mapper.map(entity, MessageDomain.class);
    }
    @Override
    public MessageData mapperEntity(MessageDomain domain) { return mapper.map(domain, MessageData.class); }
    @Override
    public MessageDTO mapperDTO(MessageData entity) { return mapper.map(entity, MessageDTO.class);}
}