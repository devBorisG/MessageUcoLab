package co.edu.uco.core.application.builder;

import co.edu.uco.core.application.dto.ParameterDTO;
import co.edu.uco.utils.helper.UtilText;
import co.edu.uco.utils.helper.UtilUUID;

import java.util.UUID;

public class ParameterDTOBuilder {
    private UUID id;
    private String name;
    private String description;

    private ParameterDTOBuilder() {
        super();
    }

    public static ParameterDTOBuilder getInstance() {
        return new ParameterDTOBuilder();
    }

    public ParameterDTOBuilder setId(UUID id) {
        this.id = UtilUUID.getDefaultUUID(id);
        return this;
    }

    public ParameterDTOBuilder setName(String name) {
        this.name = UtilText.trim(name);
        return this;
    }

    public ParameterDTOBuilder setDescription(String description) {
        this.description = UtilText.trim(description);
        return this;
    }

    public ParameterDTO build() {
        return ParameterDTO.create(id, name, description);
    }

}
