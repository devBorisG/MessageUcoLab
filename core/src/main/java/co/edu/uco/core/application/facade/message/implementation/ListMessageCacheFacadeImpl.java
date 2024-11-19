package co.edu.uco.core.application.facade.message.implementation;

import co.edu.uco.core.application.dto.MessageCodeDTO;
import co.edu.uco.core.application.mapper.dto.DTOMapper;
import co.edu.uco.core.domain.domains.MessageCodeDomain;
import co.edu.uco.core.domain.port.in.ListMessageCacheInPort;
import co.edu.uco.core.domain.usecase.handling.HandlingListMessageCacheInputPort;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;


@Service
public class ListMessageCacheFacadeImpl implements HandlingListMessageCacheInputPort {

    private final DTOMapper<MessageCodeDTO, MessageCodeDomain> assembler;
    private final ListMessageCacheInPort useCase;

    public ListMessageCacheFacadeImpl(DTOMapper<MessageCodeDTO, MessageCodeDomain> assembler, ListMessageCacheInPort useCase) {
        this.assembler = assembler;
        this.useCase = useCase;
    }

    @Override
    public void listMessage(MessageCodeDTO message, HttpServletResponse response) {
        MessageCodeDomain messageDomain = assembler.mapperDomain(message);
        useCase.execute(messageDomain, response);
    }
}
