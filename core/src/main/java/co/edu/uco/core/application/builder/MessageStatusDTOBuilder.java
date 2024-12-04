package co.edu.uco.core.application.builder;

import co.edu.uco.core.application.dto.MessageStatusDTO;
import co.edu.uco.utils.helper.UtilText;
import co.edu.uco.utils.helper.UtilUUID;

import java.util.UUID;

public class MessageStatusDTOBuilder {
    private UUID id;
    private String name;
    private String description;

    private MessageStatusDTOBuilder() {
        super();
    }

    public static MessageStatusDTOBuilder getInstance() {
        return new MessageStatusDTOBuilder();
    }

    public MessageStatusDTOBuilder setId(UUID id) {
        this.id = UtilUUID.getDefaultUUID(id);
        return this;
    }

    public MessageStatusDTOBuilder setName(String name) {
        this.name = UtilText.trim(name);
        return this;
    }

    public MessageStatusDTOBuilder setDescription(String description) {
        this.description = UtilText.trim(description);
        return this;
    }

    public MessageStatusDTO build() {
        return MessageStatusDTO.create(id, name, description);
    }
}
