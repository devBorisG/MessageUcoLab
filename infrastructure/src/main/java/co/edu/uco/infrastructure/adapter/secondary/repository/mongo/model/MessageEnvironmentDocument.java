package co.edu.uco.infrastructure.adapter.secondary.repository.mongo.model;

import co.edu.uco.utils.helper.UtilObject;
import co.edu.uco.utils.helper.UtilText;
import jakarta.persistence.Id;
import lombok.Getter;
import static co.edu.uco.utils.helper.UtilText.EMPTY;
import static co.edu.uco.utils.helper.UtilText.trim;

import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Document(collection = "message_environment")
@ToString
public final class MessageEnvironmentDocument {
    private String _id;
    @Id
    @Field("MESSAGE_ENVIRONMENT_ID")
    private String id;
    @Field("MESSAGE")
    private MessageDocument message;
    @Field("ENVIRONMENT_ID")
    private String environmentId;
    @Field("STATUS")
    private MessageEnvironmentStateDocument state;
    public MessageEnvironmentDocument(String id, MessageDocument message, String environmentId) {
        setId(id);
        setMessage(message);
        setEnvironmentId(environmentId);
    }
    public MessageEnvironmentDocument() {
        setId(EMPTY);
        setMessage(MessageDocument.build());
        setEnvironmentId(EMPTY);
    }
    public void setId(String id) {
        this.id =UtilText.trim(id);
    }
    public void setMessage(MessageDocument message) {
        this.message = UtilObject.getDefaultIsNullObject(message, MessageDocument.build());
    }
    public void setEnvironmentId(String environmentId) {
        this.environmentId = trim(environmentId);
    }
    public void setState(MessageEnvironmentStateDocument state) {
        this.state = UtilObject.getDefaultIsNullObject(state, MessageEnvironmentStateDocument.build());
    }
    public static MessageEnvironmentDocument build(){return new MessageEnvironmentDocument();}
}