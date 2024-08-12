package co.edu.uco.core.domain.customexception;

import co.edu.uco.utils.exception.BusinessRuleException;

import java.io.Serial;

public class SizeContentLessThanTenException extends BusinessRuleException {

    @Serial
    private static final long serialVersionUID = -2529239574681102198L;

    private SizeContentLessThanTenException() {
        super("El tamaño del contenido no puede ser menor a 10", "SIZE_CONTENT_LESS_THAN_TEN");
    }

    public static void report() {
        throw new SizeContentLessThanTenException();
    }
}
