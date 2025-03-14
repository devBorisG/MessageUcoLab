package co.edu.uco.infrastructure.adapter.secondary.repository.mongo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import static co.edu.uco.utils.helper.UtilText.EMPTY;
import static co.edu.uco.utils.helper.UtilText.trim;

@Getter
public final class MessageEnvironmentStateDocument {
    @JsonProperty("ID")
    private String id;
    @JsonProperty("NAME")
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