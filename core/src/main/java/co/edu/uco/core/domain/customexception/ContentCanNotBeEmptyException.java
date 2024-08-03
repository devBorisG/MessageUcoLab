package co.edu.uco.core.domain.customexception;

import java.io.Serial;

public class ContentCanNotBeEmptyException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = -2821910820329341124L;

    private ContentCanNotBeEmptyException() {
        super("El contenido no puede estar vacío");
    }

    public static void report() {
        throw new ContentCanNotBeEmptyException();
    }
}
