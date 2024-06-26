package co.edu.uco.utils.exception.customexception;

import java.io.Serial;

public class TitleCanNotBeEmptyException extends RuntimeException {

        @Serial
        private static final long serialVersionUID = 1L;

        private TitleCanNotBeEmptyException() {
            super("El título no puede estar vacío");
        }

        public static void report() {
            throw new TitleCanNotBeEmptyException();
        }
}
