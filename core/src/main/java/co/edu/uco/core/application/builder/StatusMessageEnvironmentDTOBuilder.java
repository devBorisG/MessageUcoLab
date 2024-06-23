package co.edu.uco.core.application.builder;

import co.edu.uco.core.application.dto.StatusMessageEnvironmentDTO;

import java.util.UUID;

public class StatusMessageEnvironmentDTOBuilder {
    private UUID id;
    private String name;

    private StatusMessageEnvironmentDTOBuilder() {
        super();
    }

    public static StatusMessageEnvironmentDTOBuilder getInstance() {
        return new StatusMessageEnvironmentDTOBuilder();
    }

    public StatusMessageEnvironmentDTOBuilder setId(UUID id) {
        this.id = id;
        return this;
    }

    public StatusMessageEnvironmentDTOBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public StatusMessageEnvironmentDTO build() {
        return StatusMessageEnvironmentDTO.create(id, name);
    }

}
