package co.edu.uco.core.domain.customexception;

import java.io.Serial;

public class SizeContentLessThanTenException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = -2529239574681102198L;

    private SizeContentLessThanTenException() {
        super("El contenido no puede tener menos de 10 caracteres");
    }

    public static void report() {
        throw new SizeContentLessThanTenException();
    }
}
