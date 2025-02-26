package co.edu.uco.infrastructure.adapter.secondary.repository.mongo.model;

import jakarta.persistence.Id;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import static co.edu.uco.utils.helper.UtilText.EMPTY;
import static co.edu.uco.utils.helper.UtilText.trim;
import static co.edu.uco.utils.helper.UtilObject.getDefaultIsNullObject;

@Getter
@Document(collection = "application")
public final class ApplicationDocument {
    @Id
    private String id;
    private String name;
    @DBRef
    private ApplicationStateDocument state;
    @DBRef
    private LanguageBaseDocument languageBase;
    public ApplicationDocument(String id, String name, ApplicationStateDocument state, LanguageBaseDocument languageBase) {
        setId(id);
        setName(name);
        setState(state);
        setLanguageBase(languageBase);
    }
    public ApplicationDocument() {
        setId(EMPTY);
        setName(EMPTY);
        setState(ApplicationStateDocument.build());
        setLanguageBase(LanguageBaseDocument.build());
    }
    public void setId(String id) {
        this.id = trim(id);
    }
    public void setName(String name) {
        this.name = trim(name);
    }
    public void setState(ApplicationStateDocument state) {
        this.state = getDefaultIsNullObject(state, ApplicationStateDocument.build());
    }
    public void setLanguageBase(LanguageBaseDocument languageBase) {
        this.languageBase = getDefaultIsNullObject(languageBase, LanguageBaseDocument.build());
    }
    public static ApplicationDocument build() {
        return new ApplicationDocument();
    }
}