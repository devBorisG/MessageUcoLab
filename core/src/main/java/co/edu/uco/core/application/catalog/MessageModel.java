package co.edu.uco.core.application.catalog;

import co.edu.uco.core.application.catalog.strategy.inmemory.enums.MessageCategoryEnum;
import co.edu.uco.core.application.catalog.strategy.inmemory.enums.MessageKeyEnum;
import co.edu.uco.core.application.catalog.strategy.inmemory.enums.MessageTypeEnum;
import co.edu.uco.utils.helper.UtilObject;

public record MessageModel(MessageKeyEnum code, String content, String title, MessageTypeEnum type, MessageCategoryEnum category) {

    public MessageModel {
        if (UtilObject.isNullObject(code)) {
            throw new IllegalArgumentException(MessageKeyEnum.TCH_010.getKey());
        }
        if (UtilObject.isNullObject(content)) {
            throw new IllegalArgumentException(MessageKeyEnum.TCH_011.getKey());
        }
        if (UtilObject.isNullObject(title)) {
            throw new IllegalArgumentException(MessageKeyEnum.TCH_012.getKey());
        }
        if (UtilObject.isNullObject(type)) {
            throw new IllegalArgumentException(MessageKeyEnum.TCH_013.getKey());
        }
        if (UtilObject.isNullObject(category)) {
            throw new IllegalArgumentException(MessageKeyEnum.TCH_014.getKey());
        }
    }

}
