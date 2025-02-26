package co.edu.uco.core.domain.data;

import lombok.Getter;

import java.util.UUID;

import static co.edu.uco.utils.helper.UtilText.EMPTY;
import static co.edu.uco.utils.helper.UtilText.trim;
import static co.edu.uco.utils.helper.UtilUUID.getDefaultUUID;
import static co.edu.uco.utils.helper.UtilUUID.getNewUUID;

@Getter
public final class LanguageBaseData {
    private UUID id;
    private String language;
    private String code;
    public LanguageBaseData() {
        setId(getNewUUID());
        setLanguage(EMPTY);
        setCode(EMPTY);
    }
    public LanguageBaseData(UUID id, String language, String code) {
        setId(id);
        setLanguage(language);
        setCode(code);
    }
    public void setId(UUID id) {this.id = getDefaultUUID(id);}
    public void setLanguage(String language) {this.language = trim(language);}
    public void setCode(String code) {this.code = trim(code);}
    public static LanguageBaseData build() {return new LanguageBaseData();}
}