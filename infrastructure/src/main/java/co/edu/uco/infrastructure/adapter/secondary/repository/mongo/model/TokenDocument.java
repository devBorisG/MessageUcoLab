package co.edu.uco.infrastructure.adapter.secondary.repository.mongo.model;

import co.edu.uco.utils.helper.UtilDate;
import co.edu.uco.utils.helper.UtilObject;
import jakarta.persistence.Id;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

import static co.edu.uco.utils.helper.UtilText.EMPTY;
import static co.edu.uco.utils.helper.UtilText.trim;

@Getter
@Document(collection = "token")
public final class TokenDocument {
    @Id
    private String id;
    private LocalDateTime creationDate;
    private LocalDateTime expirationDate;
    @DBRef
    private EnvironmentDocument environment;
    private String code;
    public TokenDocument(String id, LocalDateTime creationDate, LocalDateTime expirationDate, EnvironmentDocument environment,
                         String code) {
        setId(id);
        setCreationDate(creationDate);
        setExpirationDate(expirationDate);
        setEnvironment(environment);
        setCode(code);
    }
    public TokenDocument() {
        setId(EMPTY);
        setCreationDate(UtilDate.TIME);
        setExpirationDate(UtilDate.TIME);
        setEnvironment(EnvironmentDocument.build());
        setCode(EMPTY);
    }
    public void setId(String id) {
        this.id = trim(id);
    }
    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = UtilDate.getDefaultTimeIfNull(creationDate);
    }
    public void setExpirationDate(LocalDateTime expirationDate) {
        this.expirationDate = UtilDate.getDefaultTimeIfNull(expirationDate);
    }
    public void setEnvironment(EnvironmentDocument environment) {
        this.environment = UtilObject.getDefaultIsNullObject(environment, EnvironmentDocument.build());
    }
    public void setCode(String code) {
        this.code = trim(code);
    }
    public static TokenDocument build(){return new TokenDocument();}
}