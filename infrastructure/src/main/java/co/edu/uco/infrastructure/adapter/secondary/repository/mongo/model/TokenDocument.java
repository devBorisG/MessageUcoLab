package co.edu.uco.infrastructure.adapter.secondary.repository.mongo.model;

import co.edu.uco.utils.helper.UtilDate;
import jakarta.persistence.Id;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

import static co.edu.uco.utils.helper.UtilDate.getDefaultTimeIfNull;
import static co.edu.uco.utils.helper.UtilText.EMPTY;
import static co.edu.uco.utils.helper.UtilText.trim;

@Getter
@Document(collection = "token")
public final class TokenDocument {

    private String _id;
    @Id
    @Field("id")
    private String id;
//    @Field("creation_date")
//    private LocalDateTime creationDate;
//    @Field("expiration_date")
//    private LocalDateTime expirationDate;
    @Field("environment_id")
    private String environmentId;
    @Field("secret_name")
    private String secretName;
    public TokenDocument(String id, LocalDateTime creationDate, LocalDateTime expirationDate,
                         String environmentId, String secretName) {
        setId(id);
//        setCreationDate(creationDate);
//        setExpirationDate(expirationDate);
        setEnvironmentId(environmentId);
        setSecretName(secretName);
    }
    public TokenDocument() {
        setId(EMPTY);
//        setCreationDate(UtilDate.TIME);
//        setExpirationDate(UtilDate.TIME);
        setEnvironmentId(environmentId);
        setSecretName(EMPTY);
    }
    public void setId(String id) {
        this.id = trim(id);
    }
//    public void setCreationDate(LocalDateTime creationDate) {
//        this.creationDate = getDefaultTimeIfNull(creationDate);
//    }
//    public void setExpirationDate(LocalDateTime expirationDate) {
//        this.expirationDate = getDefaultTimeIfNull(expirationDate);
//    }
    public void setEnvironmentId(String environmentId) {
        this.environmentId = trim(environmentId);
    }
    public void setSecretName(String secretName) {
        this.secretName = trim(secretName);
    }
    public static TokenDocument build(){return new TokenDocument();}
}