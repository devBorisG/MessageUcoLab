package co.edu.uco.core.application.dto;

import lombok.Getter;

import java.util.UUID;

import static co.edu.uco.utils.helper.UtilObject.getDefaultIsNullObject;
import static co.edu.uco.utils.helper.UtilText.trim;
import static co.edu.uco.utils.helper.UtilUUID.getDefaultUUID;

@Getter
public class ParameterRepresentationDTO {
    private UUID id;
    private String start;
    private String end;
    private boolean defaultVal;
    private boolean isParameter;

    public ParameterRepresentationDTO(UUID id, String start, String end, boolean defaultVal, boolean isParameter) {
        setId(id);
        setStart(start);
        setEnd(end);
        setDefaultVal(defaultVal);
        setParameter(isParameter);
    }

    public void setId(UUID id) {
        this.id = getDefaultUUID(id);
    }

    public void setStart(String start) {
        this.start = trim(start);
    }

    public void setEnd(String end) { this.end = trim(end); }

    public void setDefaultVal(boolean defaultVal) { this.defaultVal = getDefaultIsNullObject(defaultVal, false); }

    public void setParameter(boolean parameter) { this.isParameter = getDefaultIsNullObject(parameter, false); }

    public static ParameterRepresentationDTO create(UUID id, String start, String end, boolean defaultVal, boolean isParameter) {
        return new ParameterRepresentationDTO(id, start, end, defaultVal, isParameter);
    }

}
