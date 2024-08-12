package co.edu.uco.core.domain.customexception;

import co.edu.uco.utils.exception.BusinessRuleException;

import java.io.Serial;

public class TitleCanNotBeEmptyException extends BusinessRuleException {

        @Serial
        private static final long serialVersionUID = 41765698692188909L;

        private TitleCanNotBeEmptyException() {
           super("El título no puede estar vacío", "TITLE_CAN_NOT_BE_EMPTY");
        }

        public static void report() {
            throw new TitleCanNotBeEmptyException();
        }
}
