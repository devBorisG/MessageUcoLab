package co.edu.uco.core.messages.validator;

import co.edu.uco.core.messages.enums.DetailMessageEnum;
import co.edu.uco.core.messages.enums.MessageKeyEnum;
import java.util.Arrays;

public class MessageValidator {

    public static boolean isValid(DetailMessageEnum detailMessage) {
        // Validar que el código no sea nulo y pertenezca a los valores permitidos
        if (detailMessage.getCode() == null || !Arrays.asList(MessageKeyEnum.values()).contains(detailMessage.getCode())) {
            System.out.println("Error: El código del mensaje no es válido o está fuera de los valores permitidos.");
            return false;
        }

        // Validar que el título no sea nulo ni esté vacío
        if (detailMessage.getTitle() == null || detailMessage.getTitle().isEmpty()) {
            System.out.println("Error: El mensaje debe tener un título.");
            return false;
        }

        // Validar que el contenido no sea nulo ni esté vacío
        if (detailMessage.getContent() == null || detailMessage.getContent().isEmpty()) {
            System.out.println("Error: El mensaje debe incluir una descripción.");
            return false;
        }

        // Validar que el tipo de mensaje no sea nulo
        if (detailMessage.getType() == null) {
            System.out.println("Error: El tipo de mensaje no está definido.");
            return false;
        }

        // Validar que la categoría del mensaje no sea nula
        if (detailMessage.getCategory() == null) {
            System.out.println("Error: La categoría del mensaje no está definida.");
            return false;
        }

        return true;
    }

    public static void validateAllMessages() {
        for (DetailMessageEnum detailMessage : DetailMessageEnum.values()) {
            if (!isValid(detailMessage)) {
                System.out.println("Error en el mensaje con el código: " + detailMessage.getCode() + ". Revisa los detalles.");
            } else {
                System.out.println("El mensaje con el código " + detailMessage.getCode() + " es válido.");
            }
        }
    }
}
