package co.edu.uco.core.application.facade.message;

import co.edu.uco.core.application.dto.MessageDTO;
import co.edu.uco.core.application.facade.UseCaseFacade;
import jakarta.servlet.http.HttpServletResponse;

public interface ListMessageFacade extends UseCaseFacade<MessageDTO, HttpServletResponse> {
}
