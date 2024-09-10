package co.edu.uco.core.domain.usecase.handling;

import co.edu.uco.core.application.dto.MessageCodeDTO;
import jakarta.servlet.http.HttpServletResponse;

public interface HandlingListMessageCacheInputPort {

    void listMessage(MessageCodeDTO message, HttpServletResponse response);

}
