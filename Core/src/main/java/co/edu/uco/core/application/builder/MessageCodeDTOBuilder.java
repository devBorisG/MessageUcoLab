package co.edu.uco.core.application.builder;

import co.edu.uco.core.application.dto.MessageCodeDTO;

public class MessageCodeDTOBuilder {
    private String code;

    private MessageCodeDTOBuilder() {
        super();
    }

    public static MessageCodeDTOBuilder getInstance() {
        return new MessageCodeDTOBuilder();
    }

    public MessageCodeDTOBuilder setCode(String code) {
        this.code = code;
        return this;
    }

    public final MessageCodeDTO build() {
        return MessageCodeDTO.create(code);
    }
}
