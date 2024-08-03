package co.edu.uco.core.domain.customexception;

import java.io.Serial;

public class SizeTitleMoreThanFiftyException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = -2432315861505641573L;

    private SizeTitleMoreThanFiftyException() {
        super("El título no puede tener más de 50 caracteres");
    }

    public static void report() {
        throw new SizeTitleMoreThanFiftyException();
    }
}
