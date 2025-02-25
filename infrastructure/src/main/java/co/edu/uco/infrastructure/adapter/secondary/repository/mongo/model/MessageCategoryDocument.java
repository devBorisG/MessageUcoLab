package co.edu.uco.infrastructure.adapter.secondary.repository.mongo.model;

import jakarta.persistence.Id;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;

import static co.edu.uco.utils.helper.UtilText.EMPTY;
import static co.edu.uco.utils.helper.UtilText.trim;

@Getter
@Document(collection = "message_category")
public final class MessageCategoryDocument {
    @Id
    private String id;
    private String name;
    public MessageCategoryDocument(String id, String name) {
        setId(id);
        setName(name);
    }
    public MessageCategoryDocument() {
        setId(EMPTY);
        setName(EMPTY);
    }
    public void setId(String id) {
        this.id = trim(id);
    }
    public void setName(String name) {
        this.name = trim(name);
    }
    public static  MessageCategoryDocument build(){return new MessageCategoryDocument();}
}