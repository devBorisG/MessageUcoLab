package co.edu.uco.utils.exception.customexception;

import java.io.Serial;

public class SizeTitleMoreThanFiftyException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    private SizeTitleMoreThanFiftyException() {
        super("El título no puede tener más de 50 caracteres");
    }

    public static void report() {
        throw new SizeTitleMoreThanFiftyException();
    }
}
