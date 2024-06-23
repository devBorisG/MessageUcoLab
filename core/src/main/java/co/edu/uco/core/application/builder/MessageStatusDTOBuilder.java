package co.edu.uco.core.application.builder;

import co.edu.uco.core.application.dto.MessageStatusDTO;

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
        this.id = id;
        return this;
    }

    public MessageStatusDTOBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public MessageStatusDTOBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public MessageStatusDTO build() {
        return MessageStatusDTO.create(id, name, description);
    }
}
