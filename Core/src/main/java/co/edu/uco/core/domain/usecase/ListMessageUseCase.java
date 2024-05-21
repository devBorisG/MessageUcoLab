package co.edu.uco.core.domain.usecase;

import co.edu.uco.core.application.dto.MessageDTO;
import co.edu.uco.core.domain.domains.MessageDomain;
import co.edu.uco.core.domain.port.in.ListMessageInPort;
import co.edu.uco.core.domain.port.out.broker.SendMessage;
import co.edu.uco.core.domain.port.out.presenter.ListMessagePresenter;
import co.edu.uco.utils.mapper.assembler.ModelAssembler;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class ListMessageUseCase implements ListMessageInPort {

    private final SendMessage sendMessage;
    private final ListMessagePresenter presenter;
    private final ModelAssembler assembler;

    public ListMessageUseCase(SendMessage sendMessage, ListMessagePresenter presenter, ModelAssembler assembler) {
        this.sendMessage = sendMessage;
        this.presenter = presenter;
        this.assembler = assembler;
    }

    @Override
    public void execute(MessageDomain messageDomain, HttpServletResponse response) {
        sendMessage.execute(messageDomain, response);
        MessageDTO messageDTO = assembler.assembleDTO(messageDomain, MessageDTO.class);
        presenter.execute(messageDTO, response);
    }
}
