package co.edu.uco.core.domain.usecase;

import co.edu.uco.core.application.dto.MessageCodeDTO;
import co.edu.uco.core.assembler.dto.DTOAssembler;
import co.edu.uco.core.domain.domains.MessageCodeDomain;
import co.edu.uco.core.domain.port.in.ListMessageInPort;
import co.edu.uco.core.domain.port.out.broker.SendMessage;
import co.edu.uco.core.domain.port.out.presenter.ListMessagePresenter;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;

@Service
public class ListMessageUseCase implements ListMessageInPort {

    private final SendMessage sendMessage;
    private final ListMessagePresenter presenter;
    private final DTOAssembler<MessageCodeDTO,MessageCodeDomain> assembler;

    public ListMessageUseCase(SendMessage sendMessage, ListMessagePresenter presenter, DTOAssembler<MessageCodeDTO, MessageCodeDomain> assembler) {
        this.sendMessage = sendMessage;
        this.presenter = presenter;
        this.assembler = assembler;
    }

    @Override
    public void execute(MessageCodeDomain messageDomain, HttpServletResponse response) {
        sendMessage.execute(messageDomain, response);
        MessageCodeDTO messageDTO = assembler.assembleDTO(messageDomain);
        presenter.execute(messageDTO, response);
    }

}
