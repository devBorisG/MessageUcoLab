package co.edu.uco.core.messages.validator;

import co.edu.uco.core.messages.enums.DetailMessageEnum;
import co.edu.uco.core.messages.enums.MessageKeyEnum;
import co.edu.uco.utils.exception.BusinessRuleException;
import co.edu.uco.utils.helper.UtilObject;
import co.edu.uco.utils.helper.UtilText;

import java.util.Arrays;


public class MessageValidator {

    public static boolean isValid(DetailMessageEnum detailMessage) {
        // Validate that the code is not null and belongs to the allowed values
        if (UtilObject.isNullObject(detailMessage.getCode()) ||
                !Arrays.asList(MessageKeyEnum.values()).contains(detailMessage.getCode())) {
            throw BusinessRuleException.buildTechnicalException(
                    DetailMessageEnum.FUN_001.getContent()  // Invalid code
            );
        }

        // Validate that the title is not null or empty using UtilText
        if (UtilText.isEmptyOrNull(detailMessage.getTitle())) {
            throw BusinessRuleException.buildTechnicalException(
                    DetailMessageEnum.FUN_002.getContent()  // Title is required
            );
        }

        // Validate that the content is not null or empty using UtilText
        if (UtilText.isEmptyOrNull(detailMessage.getContent())) {
            throw BusinessRuleException.buildTechnicalException(
                    DetailMessageEnum.FUN_003.getContent()  // Content is required
            );
        }

        // Validate that the message type is not null using UtilObject
        if (UtilObject.isNullObject(detailMessage.getType())) {
            throw BusinessRuleException.buildTechnicalException(
                    DetailMessageEnum.FUN_004.getContent()  // Type is required
            );
        }

        // Validate that the message category is not null using UtilObject
        if (UtilObject.isNullObject(detailMessage.getCategory())) {
            throw BusinessRuleException.buildTechnicalException(
                    DetailMessageEnum.FUN_005.getContent()  // Static message for null category
            );
        }

        return true;
    }

    public static void validateAllMessages() {
        for (DetailMessageEnum detailMessage : DetailMessageEnum.values()) {
            try {
                isValid(detailMessage);
                System.out.println("The message with code " + detailMessage.getCode() + " is valid.");
            } catch (BusinessRuleException exception) {
                System.err.println("Error in message with code: " + detailMessage.getCode() + ". " + exception.getTechnicalMessage());
            }
        }
    }
}