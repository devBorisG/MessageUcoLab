package co.edu.uco.core.domain.customexception;

import co.edu.uco.core.application.catalog.strategy.inmemory.enums.MessageKeyEnum;
import co.edu.uco.utils.exception.BusinessRuleException;

import java.io.Serial;

public class SizeTitleLessThanTenException extends BusinessRuleException {

    @Serial
    private static final long serialVersionUID = 7220210614113459979L;

    private SizeTitleLessThanTenException() {
       super(MessageKeyEnum.FUN_020.getKey(), MessageKeyEnum.FUN_020.getKey().toUpperCase());
    }

    public static void report() {
        throw new SizeTitleLessThanTenException();
    }
}
