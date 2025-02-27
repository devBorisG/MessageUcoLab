package co.edu.uco.core.application.dto.encrypt;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AccessRequestDTO {
    private String encryptedValue;
}
