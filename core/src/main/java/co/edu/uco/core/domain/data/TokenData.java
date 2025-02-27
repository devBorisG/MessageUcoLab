package co.edu.uco.core.domain.data;

import co.edu.uco.utils.helper.UtilDate;
import co.edu.uco.utils.helper.UtilObject;
import co.edu.uco.utils.helper.UtilText;
import lombok.Getter;

import java.time.LocalDateTime;

import static co.edu.uco.utils.helper.UtilText.trim;

@Getter
public final class TokenData {
    private String id;
    private LocalDateTime creationDate;
    private LocalDateTime expirationDate;
    private EnvironmentData environment;
    public TokenData(String id, LocalDateTime creationDate, LocalDateTime expirationDate, EnvironmentData environment) {
        setId(id);
        setCreationDate(creationDate);
        setExpirationDate(expirationDate);
        setEnvironment(environment);
    }
    public TokenData() {
        setId(UtilText.EMPTY);
        setCreationDate(UtilDate.TIME);
        setExpirationDate(UtilDate.TIME);
        setEnvironment(EnvironmentData.build());
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
    public void setEnvironment(EnvironmentData environment) {
        this.environment = UtilObject.getDefaultIsNullObject(environment, EnvironmentData.build());
    }
}