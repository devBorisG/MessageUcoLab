package co.edu.uco.core.application.dto;

import lombok.Builder;
import lombok.Getter;

import java.security.PrivateKey;
import java.util.UUID;

@Getter
@Builder
public class MessageStatusDTO {
    private UUID id;
    private String name;
    private String description;

    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
