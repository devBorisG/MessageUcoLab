package co.edu.uco.core.domain.customexception;

import co.edu.uco.core.application.catalog.strategy.inmemory.enums.MessageKeyEnum;
import co.edu.uco.utils.exception.BusinessRuleException;

import java.io.Serial;

public class ContentCanNotBeEmptyException extends BusinessRuleException {

    @Serial
    private static final long serialVersionUID = -2821910820329341124L;

    private ContentCanNotBeEmptyException() {
        super(MessageKeyEnum.FUN_017.getKey(), MessageKeyEnum.FUN_017.getKey().toUpperCase());
    }
    public static void report() {
        throw new ContentCanNotBeEmptyException();
    }
}
