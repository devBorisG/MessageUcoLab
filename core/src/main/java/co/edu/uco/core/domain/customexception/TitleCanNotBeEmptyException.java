package co.edu.uco.core.domain.customexception;

import java.io.Serial;

public class TitleCanNotBeEmptyException extends RuntimeException {

        @Serial
        private static final long serialVersionUID = 41765698692188909L;

        private TitleCanNotBeEmptyException() {
            super("El título no puede estar vacío");
        }

        public static void report() {
            throw new TitleCanNotBeEmptyException();
        }
}
