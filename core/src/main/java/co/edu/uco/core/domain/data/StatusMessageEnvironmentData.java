package co.edu.uco.core.domain.data;

import co.edu.uco.utils.helper.UtilText;
import co.edu.uco.utils.helper.UtilUUID;
import lombok.Getter;

import java.util.UUID;

import static co.edu.uco.utils.helper.UtilText.trim;
import static co.edu.uco.utils.helper.UtilUUID.getDefaultUUID;

@Getter
public final class StatusMessageEnvironmentData {
    private UUID id;
    private String name;
    public StatusMessageEnvironmentData(UUID id, String name) {
        setId(id);
        setName(name);
    }
    public StatusMessageEnvironmentData() {
        setId(UtilUUID.getNewUUID());
        setName(UtilText.EMPTY);
    }
    public void setId(UUID id) {
        this.id = getDefaultUUID(id);
    }
    public void setName(String name) {
        this.name = trim(name);
    }
}