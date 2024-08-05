package co.edu.uco.core.application.dto;

import lombok.Getter;

import static co.edu.uco.utils.helper.UtilText.getUtilText;

@Getter
public class MessageCodeDTO {
    private String code;

    public MessageCodeDTO(String code) {
        setCode(code);
    }

    public void setCode(String code) {
        this.code = getUtilText().getDefault(code);
    }

    public static MessageCodeDTO create(String code) {
        return new MessageCodeDTO(code);
    }
}
