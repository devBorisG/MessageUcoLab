package co.edu.uco.core.domain.customexception;

import co.edu.uco.utils.exception.BusinessRuleException;

import java.io.Serial;

public class SizeTitleLessThanTenException extends BusinessRuleException {

    @Serial
    private static final long serialVersionUID = 7220210614113459979L;

    private SizeTitleLessThanTenException() {
       super("El tamaño del título no puede ser menor a 10", "SIZE_TITLE_LESS_THAN_TEN");
    }

    public static void report() {
        throw new SizeTitleLessThanTenException();
    }
}
