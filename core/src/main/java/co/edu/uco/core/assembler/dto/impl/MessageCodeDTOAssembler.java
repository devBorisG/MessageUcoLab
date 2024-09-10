package co.edu.uco.core.assembler.dto.impl;

import co.edu.uco.core.application.dto.MessageCodeDTO;
import co.edu.uco.core.assembler.dto.DTOAssembler;
import co.edu.uco.core.domain.domains.MessageCodeDomain;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class MessageCodeDTOAssembler implements DTOAssembler<MessageCodeDTO, MessageCodeDomain> {
    private final ModelMapper modelMapper;

    public MessageCodeDTOAssembler(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public MessageCodeDomain assembleDomain(MessageCodeDTO dto) {
        return modelMapper.map(dto, MessageCodeDomain.class);
    }

    @Override
    public MessageCodeDTO assembleDTO(MessageCodeDomain domain) {
        return modelMapper.map(domain, MessageCodeDTO.class);
    }
}
