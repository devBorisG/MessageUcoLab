package co.edu.uco.core.domain.customexception;

import co.edu.uco.utils.exception.BusinessRuleException;

import java.io.Serial;

public class ContentCanNotBeEmptyException extends BusinessRuleException {

    @Serial
    private static final long serialVersionUID = -2821910820329341124L;

    private ContentCanNotBeEmptyException() {
        super("El contenido no puede estar vacío", "CONTENT_CAN_NOT_BE_EMPTY");
    }
    public static void report() {
        throw new ContentCanNotBeEmptyException();
    }
}
