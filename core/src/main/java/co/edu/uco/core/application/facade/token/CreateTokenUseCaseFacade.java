package co.edu.uco.core.application.facade.token;

import co.edu.uco.core.application.dto.CreateTokenDTO;
import co.edu.uco.core.application.dto.TokenDTO;

import java.util.UUID;

public interface CreateTokenUseCaseFacade {
    TokenDTO createToken(CreateTokenDTO tokenDTO, UUID application);
}
