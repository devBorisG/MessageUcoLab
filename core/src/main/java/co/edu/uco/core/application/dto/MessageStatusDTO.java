package co.edu.uco.core.application.dto;

import lombok.Getter;

import java.util.UUID;

import static co.edu.uco.utils.helper.UtilText.getUtilText;
import static co.edu.uco.utils.helper.UtilUUID.getUtilUUID;

@Getter
public class MessageStatusDTO {
    private UUID id;
    private String name;
    private String description;

    public MessageStatusDTO(UUID id, String name, String description) {
        setId(id);
        setName(name);
        setDescription(description);
    }

    public void setId(UUID id) {
        this.id = getUtilUUID().getDefaultUUID(id);
    }

    public void setName(String name) {
        this.name = getUtilText().trim(name);
    }

    public void setDescription(String description) {
        this.description = getUtilText().trim(description);
    }

    public static MessageStatusDTO create(UUID id, String name, String description) {
        return new MessageStatusDTO(id, name, description);
    }
}
