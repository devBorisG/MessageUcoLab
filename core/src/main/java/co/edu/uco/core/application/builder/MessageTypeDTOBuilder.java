package co.edu.uco.core.application.builder;

import co.edu.uco.core.application.dto.MessageTypeDTO;
import co.edu.uco.utils.helper.UtilText;
import co.edu.uco.utils.helper.UtilUUID;

import java.util.UUID;

public class MessageTypeDTOBuilder {
    private UUID id;
    private String name;

    private MessageTypeDTOBuilder() {
        super();
    }

    public static MessageTypeDTOBuilder getInstance() {
        return new MessageTypeDTOBuilder();
    }

    public MessageTypeDTOBuilder setId(UUID id) {
        this.id = UtilUUID.getDefaultUUID(id);
        return this;
    }

    public MessageTypeDTOBuilder setName(String name) {
        this.name = UtilText.trim(name);
        return this;
    }

    public MessageTypeDTO build() {
        return MessageTypeDTO.create(id, name);
    }
}
