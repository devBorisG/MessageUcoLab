package co.edu.uco.core.domain.customexception;

import java.io.Serial;

public class SizeTitleLessThanTenException extends RuntimeException{

    @Serial
    private static final long serialVersionUID = 7220210614113459979L;

    private SizeTitleLessThanTenException() {
        super("El título no puede tener menos de 10 caracteres");
    }

    public static void report() {
        throw new SizeTitleLessThanTenException();
    }
}
