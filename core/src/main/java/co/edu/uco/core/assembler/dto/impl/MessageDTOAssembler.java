package co.edu.uco.core.assembler.dto.impl;

import co.edu.uco.core.application.dto.MessageDTO;
import co.edu.uco.core.assembler.dto.DTOAssembler;
import co.edu.uco.core.domain.domains.MessageDomain;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class MessageDTOAssembler implements DTOAssembler<MessageDTO, MessageDomain> {

    private final ModelMapper modelMapper;

    public MessageDTOAssembler(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public MessageDomain assembleDomain(MessageDTO dto) {
        return modelMapper.map(dto, MessageDomain.class);
    }

    @Override
    public MessageDTO assembleDTO(MessageDomain domain) {
        return modelMapper.map(domain, MessageDTO.class);
    }
}
