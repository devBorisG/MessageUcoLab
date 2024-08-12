package co.edu.uco.core.application.dto;


import lombok.Getter;


import java.util.UUID;

import static co.edu.uco.utils.helper.UtilText.trim;
import static co.edu.uco.utils.helper.UtilUUID.getDefaultUUID;

@Getter
public class ParameterDTO {
    private UUID id;
    private String name;
    private String description;

    public ParameterDTO(UUID id, String name, String description) {
        setId(id);
        setName(name);
        setDescription(description);
    }

    public void setId(UUID id) {
        this.id = getDefaultUUID(id);
    }

    public void setName(String name) {
        this.name = trim(name);
    }

    public void setDescription(String description) {
        this.description = trim(description);
    }

    public static ParameterDTO create(UUID id, String name, String description) {
        return new ParameterDTO(id, name, description);
    }
}
