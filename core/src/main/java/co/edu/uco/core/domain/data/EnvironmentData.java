package co.edu.uco.core.domain.data;

import co.edu.uco.utils.helper.UtilUUID;
import lombok.Getter;

import java.util.UUID;

import static co.edu.uco.utils.helper.UtilObject.getDefaultIsNullObject;
import static co.edu.uco.utils.helper.UtilText.EMPTY;
import static co.edu.uco.utils.helper.UtilText.trim;
import static co.edu.uco.utils.helper.UtilUUID.getDefaultUUID;

@Getter
public final class EnvironmentData {
    private UUID id;
    private String name;
    private ApplicationData application;
    private EnvironmentTypeData typeData;
    private EnvironmentStateData environmentState;
    public EnvironmentData(UUID id, String name, ApplicationData application, EnvironmentTypeData typeData, EnvironmentStateData environmentState) {
        setId(id);
        setName(name);
        setApplication(application);
        setTypeData(typeData);
        setEnvironmentState(environmentState);
    }
    public EnvironmentData() {
        setId(UtilUUID.getNewUUID());
        setName(EMPTY);
        setApplication(ApplicationData.build());
        setTypeData(EnvironmentTypeData.build());
        setEnvironmentState(EnvironmentStateData.build());
    }
    public void setId(UUID id) {
        this.id = getDefaultUUID(id);
    }
    public void setName(String name) {
        this.name = trim(name);
    }
    public void setApplication(ApplicationData application) {this.application = getDefaultIsNullObject(application, ApplicationData.build());}
    public void setTypeData(EnvironmentTypeData typeDate) {this.typeData = getDefaultIsNullObject(typeDate, EnvironmentTypeData.build());}
    public void setEnvironmentState(EnvironmentStateData environmentState) {this.environmentState = getDefaultIsNullObject(environmentState, EnvironmentStateData.build());}
    public static EnvironmentData build() {
        return new EnvironmentData();
    }
}