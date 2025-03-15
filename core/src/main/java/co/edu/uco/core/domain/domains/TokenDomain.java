package co.edu.uco.core.domain.domains;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@NoArgsConstructor
public class TokenDomain {
    private String id;
    private String secretName;
    private LocalDateTime expirationDate;
    private UUID environmentId;
    private LocalDateTime creationDate;
    private UUID stateId = UUID.fromString("123e4567-e89b-12d3-a456-426614174023");

    public TokenDomain(String id,LocalDateTime creationDate ,LocalDateTime expirationDate, UUID environmentId, String secretName, UUID stateId) {
        setId(id);
        setSecretName(secretName);
        setExpirationDate(expirationDate);
        setEnvironmentId(environmentId);
        setCreationDate(creationDate);
        setStateId(stateId);
    }

    public TokenDomain create(String id,LocalDateTime creationDate, LocalDateTime expirationDate, UUID environmentId, String secretName, UUID tokenStateDataId) {
        return new TokenDomain(id, creationDate,expirationDate, environmentId, secretName, tokenStateDataId);
    }

    public void setExpirationDate(LocalDateTime expirationDate) {
        this.expirationDate = expirationDate;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setEnvironmentId(UUID environmentId) {
        this.environmentId = environmentId;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public void setSecretName(String secretName) {
        this.secretName = secretName;
    }

    public void setStateId(UUID stateId) {
        this.stateId = stateId;
    }
}
