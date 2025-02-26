package co.edu.uco.core.domain.data;

import co.edu.uco.utils.helper.UtilObject;
import lombok.Getter;

import java.util.UUID;

import static co.edu.uco.utils.helper.UtilObject.getDefaultIsNullObject;
import static co.edu.uco.utils.helper.UtilText.EMPTY;
import static co.edu.uco.utils.helper.UtilUUID.getNewUUID;
import static co.edu.uco.utils.helper.UtilText.trim;
import static co.edu.uco.utils.helper.UtilUUID.getDefaultUUID;

@Getter
public final class ApplicationData {
    private UUID id;
    private String name;
    private LanguageBaseData language;
    private ApplicationStateData state;
    public ApplicationData() {
        setId(getNewUUID());
        setName(EMPTY);
        setLanguage(LanguageBaseData.build());
        setState(ApplicationStateData.build());
    }
    public ApplicationData(UUID id, String name, LanguageBaseData language, ApplicationStateData state) {
        setId(id);
        setName(name);
        setLanguage(language);
        setState(state);
    }
    public void setId(UUID id) {
        this.id = getDefaultUUID(id);
    }
    public void setName(String name) {
        this.name = trim(name);
    }
    public void setLanguage(LanguageBaseData language) {this.language = getDefaultIsNullObject(language, LanguageBaseData.build());}
    public void setState(ApplicationStateData state) {this.state = UtilObject.getDefaultIsNullObject(state, ApplicationStateData.build());}
    public static ApplicationData build() {
        return new ApplicationData();
    }
}