package co.edu.uco.core.domain.data;

import lombok.Getter;

import java.util.UUID;

import static co.edu.uco.utils.helper.UtilText.EMPTY;
import static co.edu.uco.utils.helper.UtilText.trim;
import static co.edu.uco.utils.helper.UtilUUID.getDefaultUUID;

@Getter
public final class FunctionalityStateData {
    private UUID id;
    private String name;
    public FunctionalityStateData() {
        setId(UUID.randomUUID());
        setName(EMPTY);
    }
    public FunctionalityStateData(UUID id, String name) {
        setId(id);
        setName(name);
    }
    public void setId(UUID id) {
        this.id = getDefaultUUID(id);
    }
    public void setName(String name) {this.name = trim(name);}
    public static FunctionalityStateData build() {
        return new FunctionalityStateData();
    }
}