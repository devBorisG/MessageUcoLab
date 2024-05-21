package co.edu.uco.core.domain.port.out.broker;

import co.edu.uco.core.domain.domains.MessageDomain;
import co.edu.uco.core.domain.port.GenericPort;
import jakarta.servlet.http.HttpServletResponse;

public interface SendMessage extends GenericPort<MessageDomain, HttpServletResponse> {
}
