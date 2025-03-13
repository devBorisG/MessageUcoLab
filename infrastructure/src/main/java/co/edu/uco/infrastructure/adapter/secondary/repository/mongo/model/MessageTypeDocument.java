package co.edu.uco.infrastructure.adapter.secondary.repository.mongo.model;

import lombok.Getter;
import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import static co.edu.uco.utils.helper.UtilText.trim;
import static co.edu.uco.utils.helper.UtilText.EMPTY;

@Getter
@Document(collection = "message_type")
public final class MessageTypeDocument {
    @Id
    private String id;
    private String name;
    public MessageTypeDocument(String id, String name) {
        setId(id);
        setName(name);
    }
    public MessageTypeDocument() {
        setId(EMPTY);
        setName(EMPTY);
    }
    public void setId(String id) {
        this.id = trim(id);
    }
    public void setName(String name) {
        this.name = trim(name);
    }
    public static MessageTypeDocument build(){return new MessageTypeDocument();}
}