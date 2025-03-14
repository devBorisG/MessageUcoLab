package co.edu.uco.core.application.mapper.dto.impl;

import co.edu.uco.core.application.dto.MessageDTO;
import co.edu.uco.core.application.mapper.dto.DTOMapper;
import co.edu.uco.core.domain.domains.MessageDomain;
import co.edu.uco.core.domain.port.out.repository.SimplePage;
import co.edu.uco.core.domain.port.out.repository.SimplePageRequest;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public final class MessageDTOMapper implements DTOMapper<MessageDTO, MessageDomain> {
    private final ModelMapper modelMapper;
    public MessageDTOMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    @Override
    public MessageDomain mapperDomain(MessageDTO dto) {
        return modelMapper.map(dto, MessageDomain.class);
    }
    @Override
    public MessageDTO mapperDTO(MessageDomain domain) {
        return modelMapper.map(domain, MessageDTO.class);
    }

    public SimplePage<MessageDTO> toDTOPage(SimplePage<MessageDomain> page) {
        List<MessageDTO> dtos = page.getData().stream()
                .map(this::mapperDTO)
                .toList();
        return SimplePage.of(dtos, page.getPage(), page.getSize(), page.getTotalItems(), page.getTotalPages());
    }

    private int validateAndParse(String value, String fieldName) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(fieldName + " debe ser un número entero válido");
        }
    }
}