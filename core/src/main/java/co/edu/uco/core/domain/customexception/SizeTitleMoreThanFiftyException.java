package co.edu.uco.core.domain.customexception;

import co.edu.uco.utils.exception.BusinessRuleException;

import java.io.Serial;

public class SizeTitleMoreThanFiftyException extends BusinessRuleException {

    @Serial
    private static final long serialVersionUID = -2432315861505641573L;

    private SizeTitleMoreThanFiftyException() {
        super("El tamaño del título no puede ser mayor a 50", "SIZE_TITLE_MORE_THAN_FIFTY");
    }

    public static void report() {
        throw new SizeTitleMoreThanFiftyException();
    }
}
