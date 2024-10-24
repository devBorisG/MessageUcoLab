package co.edu.uco.core.application.facade.message;

import co.edu.uco.core.application.facade.UseCaseFacade;
import co.edu.uco.core.domain.data.MessageData;
import jakarta.servlet.http.HttpServletResponse;

public interface FindMessageFacade extends UseCaseFacade<MessageData, HttpServletResponse> {
}
