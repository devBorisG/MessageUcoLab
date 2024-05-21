package co.edu.uco.core.application.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
public class ParameterRepresentationDTO {
    private UUID id;
    private String start;
    private String end;
    private boolean defaultVal;
    private boolean isParameter;

    public void setId(UUID id) {
        this.id = id;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public void setDefaultVal(boolean defaultVal) {
        this.defaultVal = defaultVal;
    }

    public void setParameter(boolean parameter) {
        isParameter = parameter;
    }
}
