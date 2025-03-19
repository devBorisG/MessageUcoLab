package co.edu.uco.core.application.dto;

import co.edu.uco.utils.helper.UtilObject;
import lombok.Getter;

import java.util.UUID;

import static co.edu.uco.utils.helper.UtilText.EMPTY;
import static co.edu.uco.utils.helper.UtilUUID.getDefaultUUID;
import static co.edu.uco.utils.helper.UtilUUID.getNewUUID;

@Getter
public final class MessageEnvironmentDTO {
    private UUID id;
    private UUID message_id;
    private MessageDTO message;
    private UUID environment_type_id;
    private UUID state_data_id;
    public MessageEnvironmentDTO(UUID id, UUID message_id, MessageDTO message, UUID environment_type_id, UUID state_data_id) {
        setId(id);
        setMessage_id(message_id);
        setMessage(message);
        setEnvironment_type_id(environment_type_id);
        setState_data_id(state_data_id);
    }
    public MessageEnvironmentDTO() {
        setId(getNewUUID());
        setMessage_id(getNewUUID());
        setMessage(MessageDTO.create(EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY));
        setEnvironment_type_id(getNewUUID());
        setState_data_id(getNewUUID());
    }
    public void setId(UUID id) {
        this.id = getDefaultUUID(id);
    }
    public void setMessage_id(UUID message_id) {
        this.message_id = getDefaultUUID(message_id);
    }
    public void setEnvironment_type_id(UUID environment_type_id) {
        this.environment_type_id = getDefaultUUID(environment_type_id);
    }
    public void setState_data_id(UUID state_data_id) {
        this.state_data_id = getDefaultUUID(state_data_id);
    }
    public void setMessage(MessageDTO message) {
        this.message = UtilObject.getDefaultIsNullObject(message,MessageDTO.create(message.code(), message.title(), message.content(), message.type(),
                message.category(), message.application(), message.functionality()));
    }
    public static MessageEnvironmentDTO create(UUID id, UUID message_id, MessageDTO message, UUID environment_type_id, UUID state_data_id) {
        return new MessageEnvironmentDTO(id, message_id, message, environment_type_id, state_data_id);
    }
}