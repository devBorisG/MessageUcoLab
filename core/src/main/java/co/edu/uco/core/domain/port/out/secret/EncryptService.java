package co.edu.uco.core.domain.port.out.secret;

import co.edu.uco.core.application.dto.encrypt.AccessRequestDTO;
import co.edu.uco.core.application.dto.encrypt.AccessResponseDTO;
import co.edu.uco.core.application.dto.encrypt.KeyPairResponseDTO;

public interface EncryptService {
    KeyPairResponseDTO generateKeys();
    AccessResponseDTO access(AccessRequestDTO request);
}
