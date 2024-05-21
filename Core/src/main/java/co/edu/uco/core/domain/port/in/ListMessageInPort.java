package co.edu.uco.core.domain.port.in;

import co.edu.uco.core.domain.entities.MessageEntity;
import co.edu.uco.core.domain.port.GenericPort;
import jakarta.servlet.http.HttpServletResponse;

public interface ListMessageInPort extends GenericPort<MessageEntity, HttpServletResponse> {
}
