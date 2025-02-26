package co.edu.uco.core.domain.data;

import lombok.Getter;

import java.util.UUID;

import static co.edu.uco.utils.helper.UtilText.trim;
import static co.edu.uco.utils.helper.UtilText.EMPTY;
import static co.edu.uco.utils.helper.UtilUUID.getDefaultUUID;
import static co.edu.uco.utils.helper.UtilUUID.getNewUUID;

@Getter
public final class ApplicationStateData {
    private UUID id;
    private String name;
    public ApplicationStateData(UUID id, String name) {
        setId(id);
        setName(name);
    }
    public ApplicationStateData() {
        setId(getNewUUID());
        setName(EMPTY);
    }
    public void setId(UUID id) {
        this.id = getDefaultUUID(id);
    }
    public void setName(String name) {
        this.name = trim(name);
    }
    public static ApplicationStateData build() {return new ApplicationStateData();}
}