package co.edu.uco.core.domain.usecase;

import co.edu.uco.core.application.dto.MessageDTO;
import co.edu.uco.core.domain.entities.MessageEntity;
import co.edu.uco.core.port.in.ListMessageInPort;
import co.edu.uco.core.port.out.broker.SendMessage;
import co.edu.uco.core.port.out.presenter.ListMessagePresenter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class ListMessageUseCase implements ListMessageInPort {

    private final SendMessage sendMessage;
    private final ListMessagePresenter presenter;
    public ListMessageUseCase(SendMessage sendMessage, ListMessagePresenter presenter) {
        this.sendMessage = sendMessage;
        this.presenter = presenter;
    }

    @Override
    public void execute(MessageEntity messageEntity) {
        sendMessage.execute(messageEntity);
        MessageDTO messageDTO = new MessageDTO();
        BeanUtils.copyProperties(messageEntity, messageDTO);
        presenter.execute(messageDTO);
    }
}
