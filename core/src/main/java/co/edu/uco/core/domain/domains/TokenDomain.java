package co.edu.uco.core.domain.domains;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@NoArgsConstructor
public class TokenDomain {
    private String id;
    private LocalDateTime expirationDate;
    private UUID environmentId;
    private LocalDateTime creationDate;

    public TokenDomain(String id,LocalDateTime creationDate ,LocalDateTime expirationDate, UUID environmentId) {
        setId(id);
        setExpirationDate(expirationDate);
        setEnvironmentId(environmentId);
        setCreationDate(creationDate);
    }

    public TokenDomain create(String id,LocalDateTime creationDate, LocalDateTime expirationDate, UUID environmentId) {
        return new TokenDomain(id, creationDate,expirationDate, environmentId);
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
}
