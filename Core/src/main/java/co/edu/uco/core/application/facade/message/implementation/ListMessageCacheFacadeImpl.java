package co.edu.uco.core.application.facade.message.implementation;

import co.edu.uco.core.application.dto.MessageCodeDTO;
import co.edu.uco.core.assembler.dto.DTOAssembler;
import co.edu.uco.core.domain.domains.MessageCodeDomain;
import co.edu.uco.core.domain.port.in.ListMessageCacheInPort;
import co.edu.uco.core.domain.usecase.handling.HandlingListMessageCacheInputPort;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;


@Service
public class ListMessageCacheFacadeImpl implements HandlingListMessageCacheInputPort {

    private final DTOAssembler<MessageCodeDTO, MessageCodeDomain> assembler;
    private final ListMessageCacheInPort useCase;

    public ListMessageCacheFacadeImpl(DTOAssembler<MessageCodeDTO, MessageCodeDomain> assembler, ListMessageCacheInPort useCase) {
        this.assembler = assembler;
        this.useCase = useCase;
    }

    @Override
    public void listMessage(MessageCodeDTO message, HttpServletResponse response) {
        MessageCodeDomain messageDomain = assembler.assembleDomain(message);
        useCase.execute(messageDomain, response);
    }
}
