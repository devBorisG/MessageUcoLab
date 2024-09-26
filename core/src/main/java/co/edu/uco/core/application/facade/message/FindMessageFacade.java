package co.edu.uco.core.application.facade.message;

import co.edu.uco.core.application.facade.UseCaseFacade;
import co.edu.uco.core.domain.document.MessageDocument;
import jakarta.servlet.http.HttpServletResponse;

public interface FindMessageFacade extends UseCaseFacade<MessageDocument, HttpServletResponse> {
}
