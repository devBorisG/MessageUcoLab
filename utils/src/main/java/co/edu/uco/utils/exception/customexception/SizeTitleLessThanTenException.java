package co.edu.uco.utils.exception.customexception;

import java.io.Serial;

public class SizeTitleLessThanTenException extends RuntimeException{

    @Serial
    private static final long serialVersionUID = 1L;

    private SizeTitleLessThanTenException() {
        super("El título no puede tener menos de 10 caracteres");
    }

    public static void report() {
        throw new SizeTitleLessThanTenException();
    }
}
