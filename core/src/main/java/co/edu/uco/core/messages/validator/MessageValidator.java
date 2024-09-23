package co.edu.uco.core.messages.validator;

import co.edu.uco.core.messages.enums.DetailMessageEnum;
import co.edu.uco.core.messages.enums.MessageKeyEnum;
import co.edu.uco.utils.helper.UtilObject;
import co.edu.uco.utils.helper.UtilText;

import java.util.Arrays;


public class MessageValidator {

    public static boolean isValid(DetailMessageEnum detailMessage) {
        // Validate that the code is not null and belongs to the allowed values
        if (UtilObject.isNullObject(detailMessage.getCode()) ||
                !Arrays.asList(MessageKeyEnum.values()).contains(detailMessage.getCode())) {
            System.out.println(DetailMessageEnum.FUN_001.getContent());  // Invalid code
            return false;
        }

        // Validate that the title is not null or empty using UtilText
        if (UtilText.isEmptyOrNull(detailMessage.getTitle())) {
            System.out.println(DetailMessageEnum.FUN_002.getContent());  // Title is required
            return false;
        }

        // Validate that the content is not null or empty using UtilText
        if (UtilText.isEmptyOrNull(detailMessage.getContent())) {
            System.out.println(DetailMessageEnum.FUN_003.getContent());  // Content is required
            return false;
        }

        // Validate that the message type is not null using UtilObject
        if (UtilObject.isNullObject(detailMessage.getType())) {
            System.out.println(DetailMessageEnum.FUN_004.getContent());  // Type is required
            return false;
        }

        // Validate that the message category is not null using UtilObject
        if (UtilObject.isNullObject(detailMessage.getCategory())) {
            System.out.println(DetailMessageEnum.FUN_005.getContent());  // Category is required
            return false;
        }

        return true;
    }

    public static void validateAllMessages() {
        for (DetailMessageEnum detailMessage : DetailMessageEnum.values()) {
            if (!isValid(detailMessage)) {
                System.out.println("Error in the message with code: " + detailMessage.getCode() + ". Please check the details.");
            } else {
                System.out.println("The message with code " + detailMessage.getCode() + " is valid.");
            }
        }
    }
}