package co.edu.uco.core.application.dto;

import lombok.Getter;

import java.util.UUID;

import static co.edu.uco.utils.helper.UtilText.getUtilText;
import static co.edu.uco.utils.helper.UtilUUID.getUtilUUID;

@Getter
public class MessageEnvironmentDTO {

    private UUID id;
    private String message;

    public MessageEnvironmentDTO(UUID id, String message) {
        setId(id);
        setMessage(message);
    }

    public void setId(UUID id) {
        this.id = getUtilUUID().getDefaultUUID(id);
    }

    public void setMessage(String message) {
        this.message = getUtilText().trim(message);
    }

    public static MessageEnvironmentDTO create(UUID id, String message) {
        return new MessageEnvironmentDTO(id, message);
    }
}
