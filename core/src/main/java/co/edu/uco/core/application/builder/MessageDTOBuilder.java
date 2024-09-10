package co.edu.uco.core.application.builder;

import co.edu.uco.core.application.dto.MessageDTO;

import java.util.UUID;

public class MessageDTOBuilder {
    private UUID id;
    private String code;
    private String title;
    private String content;
    private String application;

    private MessageDTOBuilder() {
        super();
    }

    public static MessageDTOBuilder getInstance() {
        return new MessageDTOBuilder();
    }

    public MessageDTOBuilder setId(UUID id) {
        this.id = id;
        return this;
    }

    public MessageDTOBuilder setCode(String code) {
        this.code = code;
        return this;
    }

    public MessageDTOBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public MessageDTOBuilder setContent(String content) {
        this.content = content;
        return this;
    }

    public MessageDTOBuilder setApplication(String application) {
        this.application = application;
        return this;
    }

    public final MessageDTO build() {
        return MessageDTO.create(id, code, title, content, application);
    }

}
