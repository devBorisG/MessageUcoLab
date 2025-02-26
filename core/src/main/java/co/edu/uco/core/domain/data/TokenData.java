package co.edu.uco.core.domain.data;

import lombok.Getter;

import java.time.LocalDateTime;

import static co.edu.uco.utils.helper.UtilDate.TIME;
import static co.edu.uco.utils.helper.UtilDate.getDefaultTimeIfNull;
import static co.edu.uco.utils.helper.UtilObject.getDefaultIsNullObject;
import static co.edu.uco.utils.helper.UtilText.EMPTY;
import static co.edu.uco.utils.helper.UtilText.trim;

@Getter
public final class TokenData {
    private String id;
    private LocalDateTime creationDate;
    private LocalDateTime expirationDate;
    private EnvironmentData environment;
    private TokenStateData state;
    public TokenData(String id, LocalDateTime creationDate, LocalDateTime expirationDate,
                     EnvironmentData environment, TokenStateData stateData) {
        setId(id);
        setCreationDate(creationDate);
        setExpirationDate(expirationDate);
        setEnvironment(environment);
        setState(stateData);
    }
    public TokenData() {
        setId(EMPTY);
        setCreationDate(TIME);
        setExpirationDate(TIME);
        setEnvironment(EnvironmentData.build());
        setState(TokenStateData.build());
    }
    public void setId(String id) {
        this.id = trim(id);
    }
    public void setCreationDate(LocalDateTime creationDate) {this.creationDate = getDefaultTimeIfNull(creationDate);}
    public void setExpirationDate(LocalDateTime expirationDate) {this.expirationDate = getDefaultTimeIfNull(expirationDate);}
    public void setEnvironment(EnvironmentData environment) {this.environment = getDefaultIsNullObject(environment, EnvironmentData.build());}
    public void setState(TokenStateData state) {this.state = getDefaultIsNullObject(state, TokenStateData.build());}
}