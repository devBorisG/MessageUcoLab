package co.edu.uco.core.application.facade.message.implementation;

import co.edu.uco.core.application.dto.MessageDTO;
import co.edu.uco.core.application.facade.message.ListMessageFacade;
import co.edu.uco.core.assembler.dto.DTOAssembler;
import co.edu.uco.core.domain.domains.MessageDomain;
import co.edu.uco.core.domain.port.in.ListMessageInPort;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;

@Service
public class ListMessageFacadeImpl implements ListMessageFacade {

    private final DTOAssembler<MessageDTO, MessageDomain> assembler;
    private final ListMessageInPort useCase;

    public ListMessageFacadeImpl(DTOAssembler<MessageDTO, MessageDomain> assembler, ListMessageInPort useCase) {
        this.assembler = assembler;
        this.useCase = useCase;
    }

    @Override
    public void execute(MessageDTO dto, HttpServletResponse response) {
        MessageDomain messageDomain = assembler.assembleDomain(dto);
        useCase.execute(messageDomain, response);
    }
}
