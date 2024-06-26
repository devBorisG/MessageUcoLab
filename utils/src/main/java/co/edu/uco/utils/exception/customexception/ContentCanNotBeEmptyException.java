package co.edu.uco.utils.exception.customexception;

import java.io.Serial;

public class ContentCanNotBeEmptyException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    private ContentCanNotBeEmptyException() {
        super("El contenido no puede estar vacío");
    }

    public static void report() {
        throw new ContentCanNotBeEmptyException();
    }
}
