package co.edu.uco.core.application.builder;

import co.edu.uco.core.application.dto.ParameterDTO;

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
        this.id = id;
        return this;
    }

    public ParameterDTOBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public ParameterDTOBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public ParameterDTO build() {
        return ParameterDTO.create(id, name, description);
    }

}
