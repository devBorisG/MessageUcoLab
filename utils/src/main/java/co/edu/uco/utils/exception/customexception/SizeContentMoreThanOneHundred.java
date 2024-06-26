package co.edu.uco.utils.exception.customexception;

import java.io.Serial;

public class SizeContentMoreThanOneHundred extends RuntimeException {

        @Serial
        private static final long serialVersionUID = 1L;

        private SizeContentMoreThanOneHundred() {
            super("El contenido no puede tener más de cien caracteres!!!!");
        }

        public static void report() {
            throw new SizeContentMoreThanOneHundred();
        }
}
