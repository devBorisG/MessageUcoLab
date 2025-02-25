package co.edu.uco.infrastructure.adapter.secondary.repository.mongo.model;

import jakarta.persistence.Id;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;

import static co.edu.uco.utils.helper.UtilText.EMPTY;
import static co.edu.uco.utils.helper.UtilText.trim;

@Getter
@Document(collection = "message_environment_state")
public final class MessageEnvironmentStateDocument {
    @Id
    private String id;
    private String name;
    public MessageEnvironmentStateDocument(String id, String name) {
        setId(id);
        setName(name);
    }
    public MessageEnvironmentStateDocument() {
        setId(EMPTY);
        setName(EMPTY);
    }
    public void setId(String id) {
        this.id = trim(id);
    }
    public void setName(String name) {
        this.name = trim(name);
    }
    public static MessageEnvironmentStateDocument build() {
        return new MessageEnvironmentStateDocument();
    }
}