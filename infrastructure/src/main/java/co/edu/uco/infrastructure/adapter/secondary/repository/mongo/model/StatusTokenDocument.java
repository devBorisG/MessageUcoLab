package co.edu.uco.infrastructure.adapter.secondary.repository.mongo.model;

import jakarta.persistence.Id;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;

import static co.edu.uco.utils.helper.UtilText.EMPTY;
import static co.edu.uco.utils.helper.UtilText.trim;

@Getter
@Document(collection = "status_token")
public final class StatusTokenDocument {
    @Id
    private String id;
    private String name;
    public StatusTokenDocument() {
        setId(EMPTY);
        setName(EMPTY);
    }
    public StatusTokenDocument(String id, String name) {
        setId(id);
        setName(name);
    }
    public void setId(String id) {
        this.id = trim(id);
    }
    public void setName(String name) {
        this.name = trim(name);
    }
    public static StatusTokenDocument build() {
        return new StatusTokenDocument();
    }
}