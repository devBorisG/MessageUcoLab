package co.edu.uco.core.application.facade.message;

import co.edu.uco.core.application.facade.UseCaseFacade;
import co.edu.uco.core.assembler.pojo.Message;
import jakarta.servlet.http.HttpServletResponse;

public interface FindMessageFacade extends UseCaseFacade<Message, HttpServletResponse> {
}
