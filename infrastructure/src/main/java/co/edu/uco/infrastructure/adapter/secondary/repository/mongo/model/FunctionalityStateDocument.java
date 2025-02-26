package co.edu.uco.infrastructure.adapter.secondary.repository.mongo.model;

import co.edu.uco.core.domain.data.FunctionalityStateData;
import lombok.Getter;

import java.util.UUID;

import static co.edu.uco.utils.helper.UtilText.EMPTY;
import static co.edu.uco.utils.helper.UtilText.trim;
import static co.edu.uco.utils.helper.UtilUUID.getDefaultUUID;

@Getter
public class FunctionalityStateDocument {
    private UUID id;
    private String name;
    public FunctionalityStateDocument() {
        setId(UUID.randomUUID());
        setName(EMPTY);
    }
    public FunctionalityStateDocument(UUID id, String name) {
        setId(id);
        setName(name);
    }
    public void setId(UUID id) {
        this.id = getDefaultUUID(id);
    }
    public void setName(String name) {this.name = trim(name);}
    public static FunctionalityStateDocument build() {
        return new FunctionalityStateDocument();
    }

}
