package co.edu.uco.infrastructure.adapter.secondary.repository.mongo.model;

import jakarta.persistence.Id;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import static co.edu.uco.utils.helper.UtilText.EMPTY;
import static co.edu.uco.utils.helper.UtilText.trim;
import static co.edu.uco.utils.helper.UtilObject.getDefaultIsNullObject;

@Getter
@Document("environment")
public final class EnvironmentDocument {
    @Id
    String id;
    private String name;
    @DBRef
    private ApplicationDocument application;
    @DBRef
    private EnvironmentTypeDocument type;
    @DBRef
    private EnvironmentStateDocument state;
    public EnvironmentDocument(String id, String name, ApplicationDocument application) {
        setId(id);
        setName(name);
        setApplication(application);
    }
    public EnvironmentDocument() {
        setId(EMPTY);
        setName(EMPTY);
        setApplication(ApplicationDocument.build());
    }
    public void setId(String id) {
        this.id = trim(id);
    }
    public void setName(String name) {
        this.name = trim(name);
    }
    public void setApplication(ApplicationDocument application) {
        this.application = getDefaultIsNullObject(application, ApplicationDocument.build());
    }
    public void setState(EnvironmentStateDocument state) {
        this.state = getDefaultIsNullObject(state, EnvironmentStateDocument.build());
    }

    public void setType(EnvironmentTypeDocument type) {
        this.type = getDefaultIsNullObject(type, EnvironmentTypeDocument.build());
    }

    public static EnvironmentDocument build() {
        return new EnvironmentDocument();
    }
}