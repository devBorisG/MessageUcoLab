package co.edu.uco.infrastructure.adapter.secondary.repository.mongo.model;

import co.edu.uco.core.domain.data.MessageData;
import co.edu.uco.utils.helper.UtilObject;
import jakarta.persistence.Id;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import static co.edu.uco.utils.helper.UtilText.EMPTY;
import static co.edu.uco.utils.helper.UtilText.trim;

@Getter
@Document(collection = "parameter")
public final class ParameterDocument {
    @Id
    private String id;
    @DBRef
    private MessageData message;
    private String name;
    private String description;

    public ParameterDocument(String id, MessageData message, String name, String description){
        setId(id);
        setMessage(message);
        setName(name);
        setDescription(description);
    }

    public ParameterDocument(){
        setId(EMPTY);
        setMessage(MessageData.build());
        setName(EMPTY);
        setDescription(EMPTY);
    }

    public void setId(String id) {
        this.id = trim(id);
    }

    public void setMessage(MessageData message) {
        this.message = UtilObject.getDefaultIsNullObject(message, MessageData.build());
    }

    public void setName(String name) {
        this.name = trim(name);
    }

    public void setDescription(String description) {
        this.description = trim(description);
    }

    public static ParameterDocument build (){return new ParameterDocument();}
}