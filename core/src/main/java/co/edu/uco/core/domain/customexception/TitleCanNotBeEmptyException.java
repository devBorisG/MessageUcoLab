package co.edu.uco.core.domain.customexception;

import co.edu.uco.core.application.catalog.strategy.inmemory.enums.MessageKeyEnum;
import co.edu.uco.utils.exception.BusinessRuleException;

import java.io.Serial;

public class TitleCanNotBeEmptyException extends BusinessRuleException {

        @Serial
        private static final long serialVersionUID = 41765698692188909L;

        private TitleCanNotBeEmptyException() {
           super(MessageKeyEnum.FUN_022.getKey(), MessageKeyEnum.FUN_022.getKey().toUpperCase());
        }

        public static void report() {
            throw new TitleCanNotBeEmptyException();
        }
}
