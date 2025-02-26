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
    private EnvironmentTypeData environmentTypeData;
    private MessageEnvironmentStateData stateData;
    public MessageEnvironmentData(UUID id, MessageData message, EnvironmentTypeData environmentTypeData, MessageEnvironmentStateData stateData) {
        setId(id);
        setMessage(message);
        setEnvironmentTypeData(environmentTypeData);
        setStateData(stateData);
    }
    public MessageEnvironmentData() {
        setId(getNewUUID());
        setMessage(MessageData.build());
        setEnvironmentTypeData(EnvironmentTypeData.build());
        setStateData(MessageEnvironmentStateData.build());
    }
    public void setId(UUID id) {
        this.id = getDefaultUUID(id);
    }
    public void setMessage(MessageData message) {this.message = getDefaultIsNullObject(message, MessageData.build());}
    public void setEnvironmentTypeData(EnvironmentTypeData environmentTypeData) {this.environmentTypeData = getDefaultIsNullObject(environmentTypeData, EnvironmentTypeData.build());}
    public void setStateData(MessageEnvironmentStateData stateData) {this.stateData = getDefaultIsNullObject(stateData, MessageEnvironmentStateData.build());}
}