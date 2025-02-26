package co.edu.uco.core.domain.data;

import lombok.Getter;

import java.util.UUID;

import static co.edu.uco.utils.helper.UtilObject.getDefaultIsNullObject;
import static co.edu.uco.utils.helper.UtilUUID.getNewUUID;
import static co.edu.uco.utils.helper.UtilUUID.getDefaultUUID;

@Getter
public final class MessageEnvironmentData {
    private UUID id;
    private MessageData message;
    private EnvironmentData environment;
    private MessageEnvironmentStateData stateData;
    public MessageEnvironmentData(UUID id, MessageData message, EnvironmentData environment, MessageEnvironmentStateData stateData) {
        setId(id);
        setMessage(message);
        setEnvironmentData(environment);
        setStateData(stateData);
    }
    public MessageEnvironmentData() {
        setId(getNewUUID());
        setMessage(MessageData.build());
        setEnvironmentData(EnvironmentData.build());
        setStateData(MessageEnvironmentStateData.build());
    }
    public void setId(UUID id) {
        this.id = getDefaultUUID(id);
    }
    public void setMessage(MessageData message) {this.message = getDefaultIsNullObject(message, MessageData.build());}
    public void setEnvironmentData(EnvironmentData environment) {this.environment = getDefaultIsNullObject(environment, EnvironmentData.build());}
    public void setStateData(MessageEnvironmentStateData stateData) {this.stateData = getDefaultIsNullObject(stateData, MessageEnvironmentStateData.build());}
}