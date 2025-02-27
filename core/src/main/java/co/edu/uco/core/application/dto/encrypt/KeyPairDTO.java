package co.edu.uco.core.application.dto.encrypt;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.security.PrivateKey;
import java.security.PublicKey;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class KeyPairDTO {
    private PublicKey publicKey;
    private PrivateKey privateKey;
}