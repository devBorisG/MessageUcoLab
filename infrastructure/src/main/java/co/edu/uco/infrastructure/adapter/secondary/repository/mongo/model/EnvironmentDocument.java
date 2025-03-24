package co.edu.uco.infrastructure.adapter.secondary.repository.mongo.model;

import co.edu.uco.utils.helper.UtilText;
import jakarta.persistence.Id;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import static co.edu.uco.infrastructure.configuration.InfrastructureConstant.COLLECTION_ENVIRONMENT;
import static co.edu.uco.utils.helper.UtilObject.getDefaultIsNullObject;

@Getter
@Document(COLLECTION_ENVIRONMENT)
public final class EnvironmentDocument {
    @Id
    String id;
    private String name;
    @DBRef
    private ApplicationDocument application;
    public EnvironmentDocument(String id, String name, ApplicationDocument application) {
        setId(id);
        setName(name);
        setApplication(application);
    }
    public EnvironmentDocument() {
        setId(UtilText.EMPTY);
        setName(UtilText.EMPTY);
        setApplication(ApplicationDocument.build());
    }
    public void setId(String id) {
        this.id = UtilText.trim(id);
    }
    public void setName(String name) {
        this.name = UtilText.trim(name);
    }
    public void setApplication(ApplicationDocument application) {this.application = getDefaultIsNullObject(application, ApplicationDocument.build());}
    public static EnvironmentDocument build() {
        return new EnvironmentDocument();
    }
}