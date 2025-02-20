package co.edu.uco.core.domain.data;

import co.edu.uco.utils.helper.UtilObject;
import co.edu.uco.utils.helper.UtilText;
import co.edu.uco.utils.helper.UtilUUID;
import lombok.Getter;

import java.util.UUID;

@Getter
public final class EnvironmentData {
    private UUID id;
    private String name;
    private ApplicationData application;
    public EnvironmentData(UUID id, String name, ApplicationData application) {
        setId(id);
        setName(name);
        setApplication(application);
    }
    public EnvironmentData() {
        setId(UtilUUID.getNewUUID());
        setName(UtilText.EMPTY);
        setApplication(ApplicationData.build());
    }
    public void setId(UUID id) {
        this.id = UtilUUID.getDefaultUUID(id);
    }
    public void setName(String name) {
        this.name = UtilText.trim(name);
    }
    public void setApplication(ApplicationData application) {
        this.application = UtilObject.getDefaultIsNullObject(application, ApplicationData.build());
    }
    
    public static EnvironmentData build() {
        return new EnvironmentData();
    }
}