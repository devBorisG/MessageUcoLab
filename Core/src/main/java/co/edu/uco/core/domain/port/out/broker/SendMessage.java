package co.edu.uco.core.domain.port.out.broker;

import co.edu.uco.core.domain.entities.MessageEntity;
import co.edu.uco.core.domain.port.GenericPort;
import jakarta.servlet.http.HttpServletResponse;

public interface SendMessage extends GenericPort<MessageEntity, HttpServletResponse> {
}
