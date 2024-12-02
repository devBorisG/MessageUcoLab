package co.edu.uco.core.application.builder;

import co.edu.uco.core.application.dto.MessageCodeDTO;
import co.edu.uco.utils.helper.UtilText;

public class MessageCodeDTOBuilder {
    private String code;

    private MessageCodeDTOBuilder() {
        super();
    }

    public static MessageCodeDTOBuilder getInstance() {
        return new MessageCodeDTOBuilder();
    }

    public MessageCodeDTOBuilder setCode(String code) {
        this.code = UtilText.trim(code);
        return this;
    }

    public final MessageCodeDTO build() {
        return MessageCodeDTO.create(code);
    }
}
