package co.edu.uco.core.application.dto.encrypt;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccessResponseDTO {
    private boolean access;
    private String message;
}
