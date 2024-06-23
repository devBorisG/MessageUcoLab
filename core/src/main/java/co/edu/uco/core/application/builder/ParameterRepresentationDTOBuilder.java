package co.edu.uco.core.application.builder;

import co.edu.uco.core.application.dto.ParameterRepresentationDTO;

import java.util.UUID;

public class ParameterRepresentationDTOBuilder {
    private UUID id;
    private String start;
    private String end;
    private boolean defaultVal;
    private boolean isParameter;

    private ParameterRepresentationDTOBuilder() {
        super();
    }

    public static ParameterRepresentationDTOBuilder getInstance() {
        return new ParameterRepresentationDTOBuilder();
    }

    public ParameterRepresentationDTOBuilder setId(UUID id) {
        this.id = id;
        return this;
    }

    public ParameterRepresentationDTOBuilder setStart(String start) {
        this.start = start;
        return this;
    }

    public ParameterRepresentationDTOBuilder setEnd(String end) {
        this.end = end;
        return this;
    }

    public ParameterRepresentationDTOBuilder setDefaultVal(boolean defaultVal) {
        this.defaultVal = defaultVal;
        return this;
    }

    public ParameterRepresentationDTOBuilder setIsParameter(boolean isParameter) {
        this.isParameter = isParameter;
        return this;
    }

    public ParameterRepresentationDTO build() {
        return ParameterRepresentationDTO.create(id, start, end, defaultVal, isParameter);
    }

}
