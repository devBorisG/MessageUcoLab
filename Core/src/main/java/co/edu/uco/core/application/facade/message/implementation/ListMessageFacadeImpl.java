package co.edu.uco.core.application.facade.message.implementation;

import co.edu.uco.core.application.dto.MessageDTO;
import co.edu.uco.core.assembler.dto.DTOAssembler;
import co.edu.uco.core.domain.domains.MessageDomain;
import co.edu.uco.core.domain.port.in.ListMessageInPort;
import co.edu.uco.core.domain.usecase.handling.HandlingListMessageInputPort;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;

@Service
public class ListMessageFacadeImpl implements HandlingListMessageInputPort {

    private final DTOAssembler<MessageDTO, MessageDomain> assembler;
    private final ListMessageInPort useCase;

    public ListMessageFacadeImpl(DTOAssembler<MessageDTO, MessageDomain> assembler, ListMessageInPort useCase) {
        this.assembler = assembler;
        this.useCase = useCase;
    }

    @Override
    public void listMessage(MessageDTO dto, HttpServletResponse response) {
        MessageDomain messageDomain = assembler.assembleDomain(dto);
        useCase.execute(messageDomain, response);
    }
}
