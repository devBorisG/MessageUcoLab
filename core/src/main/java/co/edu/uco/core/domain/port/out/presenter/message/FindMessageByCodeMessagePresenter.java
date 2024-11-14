package co.edu.uco.core.domain.port.out.presenter.message;

import co.edu.uco.core.application.dto.MessageDTO;
import co.edu.uco.core.domain.port.GenericPort;
import jakarta.servlet.http.HttpServletResponse;

public interface FindMessageByCodeMessagePresenter extends GenericPort<MessageDTO, HttpServletResponse> {
}
