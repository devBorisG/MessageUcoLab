package co.edu.uco.core.domain.data;

import co.edu.uco.utils.helper.UtilText;
import co.edu.uco.utils.helper.UtilUUID;
import lombok.Getter;

import java.util.UUID;

import static co.edu.uco.utils.helper.UtilText.trim;
import static co.edu.uco.utils.helper.UtilUUID.getDefaultUUID;

@Getter
public final class ParameterData {
    private UUID id;
    private String message;
    private String name;
    private String description;
    public ParameterData(UUID id, String message, String name, String description){
        setId(id);
        setMessage(message);
        setName(name);
        setDescription(description);
    }
    public ParameterData(){
        setId(UtilUUID.getNewUUID());
        setMessage(UtilText.EMPTY);
        setName(UtilText.EMPTY);
        setDescription(UtilText.EMPTY);
    }
    public void setId(UUID id) {
        this.id = getDefaultUUID(id);
    }
    public void setMessage(String message) {
        this.message = trim(message);
    }
    public void setName(String name) {
        this.name = trim(name);
    }
    public void setDescription(String description) {
        this.description = trim(description);
    }
}