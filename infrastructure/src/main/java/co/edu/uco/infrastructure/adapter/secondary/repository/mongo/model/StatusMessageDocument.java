package co.edu.uco.infrastructure.adapter.secondary.repository.mongo.model;

import jakarta.persistence.Id;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;

import static co.edu.uco.utils.helper.UtilText.EMPTY;
import static co.edu.uco.utils.helper.UtilText.trim;

@Getter
@Document(collection = "message_status")
public final class StatusMessageDocument {
    @Id
    private String id;
    private String name;
    public StatusMessageDocument() {
        setId(EMPTY);
        setName(EMPTY);
    }
    public StatusMessageDocument(String id, String name) {
        setId(id);
        setName(name);
    }
    public void setId(String id) {
        this.id = trim(id);
    }
    public void setName(String name) {
        this.name = trim(name);
    }
    public static StatusMessageDocument build() {
        return new StatusMessageDocument();
    }
}