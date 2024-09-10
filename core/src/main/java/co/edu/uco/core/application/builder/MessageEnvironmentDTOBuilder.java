package co.edu.uco.core.application.builder;

import co.edu.uco.core.application.dto.MessageEnvironmentDTO;

import java.util.UUID;

public class MessageEnvironmentDTOBuilder {
    private UUID id;
    private String message;

    private MessageEnvironmentDTOBuilder() {
        super();
    }

    public static MessageEnvironmentDTOBuilder getInstance() {
        return new MessageEnvironmentDTOBuilder();
    }

    public MessageEnvironmentDTOBuilder setId(UUID id) {
        this.id = id;
        return this;
    }

    public MessageEnvironmentDTOBuilder setMessage(String message) {
        this.message = message;
        return this;
    }

    public MessageEnvironmentDTO build() {
        return MessageEnvironmentDTO.create(id, message);
    }
}
