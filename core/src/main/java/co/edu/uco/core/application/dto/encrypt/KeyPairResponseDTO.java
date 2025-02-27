package co.edu.uco.core.application.dto.encrypt;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KeyPairResponseDTO {
    private String publicKey;
    private String privateKey;
}