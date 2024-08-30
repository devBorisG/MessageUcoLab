package co.edu.uco.core.domain.port.in;

import co.edu.uco.core.domain.domains.MessageCodeDomain;
import co.edu.uco.core.domain.port.GenericPort;
import jakarta.servlet.http.HttpServletResponse;

public interface ListMessageInPort extends GenericPort<MessageCodeDomain, HttpServletResponse> {
}
