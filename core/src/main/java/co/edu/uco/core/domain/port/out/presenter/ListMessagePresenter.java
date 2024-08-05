package co.edu.uco.core.domain.port.out.presenter;

import co.edu.uco.core.application.dto.MessageCodeDTO;
import co.edu.uco.core.domain.port.GenericPort;
import jakarta.servlet.http.HttpServletResponse;

public interface ListMessagePresenter extends GenericPort<MessageCodeDTO, HttpServletResponse> {
}
