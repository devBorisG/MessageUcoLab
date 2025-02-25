package co.edu.uco.infrastructure.adapter.secondary.repository.mongo.model;

import co.edu.uco.core.domain.data.MessageData;
import co.edu.uco.utils.helper.UtilObject;
import co.edu.uco.utils.helper.UtilText;
import jakarta.persistence.Id;
import lombok.Getter;
import static co.edu.uco.utils.helper.UtilText.EMPTY;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Document(collection = "message_environment")
public final class MessageEnvironmentDocument {
    @Id
    private String id;
    @DBRef
    private MessageData message;
    private EnvironmentTypeDocument environmentTypeDocument;
    private MessageEnvironmentStateDocument stateData;
    public MessageEnvironmentDocument(String id, MessageData message, EnvironmentTypeDocument environmentTypeDocument) {
        setId(id);
        setMessage(message);
        setEnvironmentTypeDocument(environmentTypeDocument);
    }
    public MessageEnvironmentDocument() {
        setId(EMPTY);
        setMessage(MessageData.build());
        setEnvironmentTypeDocument(EnvironmentTypeDocument.build());
    }
    public void setId(String id) {
        this.id =UtilText.trim(id);
    }
    public void setMessage(MessageData message) {
        this.message = UtilObject.getDefaultIsNullObject(message, MessageData.build());
    }
    public void setEnvironmentTypeDocument(EnvironmentTypeDocument environmentTypeDocument) {
        this.environmentTypeDocument = UtilObject.getDefaultIsNullObject(environmentTypeDocument, EnvironmentTypeDocument.build());
    }
    public void setStateData(MessageEnvironmentStateDocument stateData) {
        this.stateData = UtilObject.getDefaultIsNullObject(stateData, MessageEnvironmentStateDocument.build());
    }

    public static MessageEnvironmentDocument build(){return new MessageEnvironmentDocument();}
}