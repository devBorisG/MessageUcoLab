package co.edu.uco.infrastructure.adapter.secondary.repository.mongo.model;

import java.util.UUID;

import static co.edu.uco.utils.helper.UtilText.EMPTY;
import static co.edu.uco.utils.helper.UtilText.trim;
import static co.edu.uco.utils.helper.UtilUUID.getDefaultUUID;
import static co.edu.uco.utils.helper.UtilUUID.getNewUUID;

public class LanguageBaseDocument {
    private UUID id;
    private String language;
    private String code;
    public LanguageBaseDocument() {
        setId(getNewUUID());
        setLanguage(EMPTY);
        setCode(EMPTY);
    }
    public LanguageBaseDocument(UUID id, String language, String code) {
        setId(id);
        setLanguage(language);
        setCode(code);
    }
    public void setId(UUID id) {this.id = getDefaultUUID(id);}
    public void setLanguage(String language) {this.language = trim(language);}
    public void setCode(String code) {this.code = trim(code);}
    public static LanguageBaseDocument build() {return new LanguageBaseDocument();}

}
