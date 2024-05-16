package co.edu.uco.core.entity.usecase;

import co.edu.uco.core.entity.entities.MessageEntity;
import co.edu.uco.core.port.in.ListMessageInPort;
import co.edu.uco.core.port.out.broker.SendMessage;
import org.springframework.stereotype.Service;

@Service
public class ListMessageUseCase implements ListMessageInPort {

    private final SendMessage sendMessage;

    public ListMessageUseCase(SendMessage sendMessage) {
        this.sendMessage = sendMessage;
    }

    @Override
    public void execute(MessageEntity messageEntity) {
        sendMessage.execute(messageEntity);
    }
}
