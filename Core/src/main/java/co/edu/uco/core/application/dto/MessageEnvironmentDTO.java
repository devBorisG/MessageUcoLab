package co.edu.uco.core.application.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
public class MessageEnvironmentDTO {
    private UUID id;
    private String message;

    public void setId(UUID id) {
        this.id = id;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
