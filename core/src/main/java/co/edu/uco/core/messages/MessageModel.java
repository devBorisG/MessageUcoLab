package co.edu.uco.core.messages;

import co.edu.uco.core.messages.enums.MessageCategoryEnum;
import co.edu.uco.core.messages.enums.MessageKeyEnum;
import co.edu.uco.core.messages.enums.MessageTypeEnum;
import co.edu.uco.utils.helper.UtilObject;

public record MessageModel(MessageKeyEnum code, String content, String title, MessageTypeEnum type, MessageCategoryEnum category) {

    public MessageModel {
        if (UtilObject.isNullObject(code)) {
            throw new IllegalArgumentException("Code is required");
        }
        if (UtilObject.isNullObject(content)) {
            throw new IllegalArgumentException("Content is required");
        }
        if (UtilObject.isNullObject(title)) {
            throw new IllegalArgumentException("Title is required");
        }
        if (UtilObject.isNullObject(type)) {
            throw new IllegalArgumentException("Type is required");
        }
        if (UtilObject.isNullObject(category)) {
            throw new IllegalArgumentException("Category is required");
        }
    }

}
