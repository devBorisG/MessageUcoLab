package co.edu.uco.core.domain.usecase.handling;

import co.edu.uco.core.application.dto.MessageDTO;
import jakarta.servlet.http.HttpServletResponse;

public interface HandlingListMessageInputPort {

    void listMessage(MessageDTO message, HttpServletResponse response);

}
