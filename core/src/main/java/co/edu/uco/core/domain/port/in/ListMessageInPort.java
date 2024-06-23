package co.edu.uco.core.domain.port.in;

import co.edu.uco.core.domain.domains.MessageDomain;
import co.edu.uco.core.domain.port.GenericPort;
import jakarta.servlet.http.HttpServletResponse;

public interface ListMessageInPort extends GenericPort<MessageDomain, HttpServletResponse> {
}
