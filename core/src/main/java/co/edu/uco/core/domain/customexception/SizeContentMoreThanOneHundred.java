package co.edu.uco.core.domain.customexception;

import co.edu.uco.utils.exception.BusinessRuleException;

import java.io.Serial;

public class SizeContentMoreThanOneHundred extends BusinessRuleException {

        @Serial
        private static final long serialVersionUID = -4177616618105416722L;

        private SizeContentMoreThanOneHundred() {
            super("El tamaño del contenido no puede ser mayor a 100", "SIZE_CONTENT_MORE_THAN_ONE_HUNDRED");
        }

        public static void report() {
            throw new SizeContentMoreThanOneHundred();
        }
}
