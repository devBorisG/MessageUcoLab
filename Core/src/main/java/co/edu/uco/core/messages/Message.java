package co.edu.uco.core.messages;

import co.edu.uco.utils.helper.UtilObject;

public record Message(MessageCatalogEnum code, String content, String title, TypeMessageEnum type, CategoryMessageEnum category) {

    public Message {
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
