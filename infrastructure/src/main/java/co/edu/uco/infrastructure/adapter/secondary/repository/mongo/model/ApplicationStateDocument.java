package co.edu.uco.infrastructure.adapter.secondary.repository.mongo.model;

import lombok.Getter;

import java.util.UUID;

import static co.edu.uco.utils.helper.UtilText.EMPTY;
import static co.edu.uco.utils.helper.UtilText.trim;
import static co.edu.uco.utils.helper.UtilUUID.getDefaultUUID;
import static co.edu.uco.utils.helper.UtilUUID.getNewUUID;

@Getter
public final class ApplicationStateDocument {
    private UUID id;
    private String name;
    public ApplicationStateDocument(UUID id, String name) {
        setId(id);
        setName(name);
    }
    public ApplicationStateDocument() {
        setId(getNewUUID());
        setName(EMPTY);
    }
    public void setId(UUID id) {
        this.id = getDefaultUUID(id);
    }
    public void setName(String name) {
        this.name = trim(name);
    }
    public static ApplicationStateDocument build() {return new ApplicationStateDocument();}
}
