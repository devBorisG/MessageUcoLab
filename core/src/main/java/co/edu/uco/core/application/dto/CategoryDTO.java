package co.edu.uco.core.application.dto;

import lombok.Getter;

import java.util.UUID;

import static co.edu.uco.utils.helper.UtilText.trim;
import static co.edu.uco.utils.helper.UtilUUID.getDefaultUUID;

@Getter
public class CategoryDTO {
    private UUID id;
    private String name;

    public void setId(UUID id) {
        this.id = getDefaultUUID(id);
    }

    public void setName(String name) {
        this.name = trim(name);
    }

    public CategoryDTO(UUID id, String name) {
        setId(id);
        setName(name);
    }

    public static CategoryDTO create(UUID id, String name) {
        return new CategoryDTO(id, name);
    }

}
