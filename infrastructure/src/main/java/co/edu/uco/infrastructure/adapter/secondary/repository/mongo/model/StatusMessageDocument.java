package co.edu.uco.infrastructure.adapter.secondary.repository.mongo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import static co.edu.uco.utils.helper.UtilText.EMPTY;
import static co.edu.uco.utils.helper.UtilText.trim;

@Getter
public final class StatusMessageDocument {
    @JsonProperty("ID")
    private String id;
    @JsonProperty("NAME")
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