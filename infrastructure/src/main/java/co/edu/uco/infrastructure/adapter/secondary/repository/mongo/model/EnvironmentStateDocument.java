package co.edu.uco.infrastructure.adapter.secondary.repository.mongo.model;

import lombok.Getter;

import java.util.UUID;

import static co.edu.uco.utils.helper.UtilText.EMPTY;
import static co.edu.uco.utils.helper.UtilText.trim;
import static co.edu.uco.utils.helper.UtilUUID.getDefaultUUID;
import static co.edu.uco.utils.helper.UtilUUID.getNewUUID;

@Getter
public final class EnvironmentStateDocument {
    private UUID id;
    private String name;
    public void setId(UUID id) {this.id = getDefaultUUID(id);}
    public void setName(String name) {this.name = trim(name);}
    public EnvironmentStateDocument() {
        setId(getNewUUID());
        setName(EMPTY);
    }
    public EnvironmentStateDocument(UUID id, String name) {
        setId(id);
        setName(name);
    }
    public static EnvironmentStateDocument build() {return new EnvironmentStateDocument();}
}
