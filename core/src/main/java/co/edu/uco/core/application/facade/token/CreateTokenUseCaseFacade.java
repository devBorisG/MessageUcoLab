package co.edu.uco.core.application.facade.token;

import co.edu.uco.core.application.dto.CreateTokenDTO;

import java.util.UUID;

public interface CreateTokenUseCaseFacade {
    String createToken(CreateTokenDTO tokenDTO, UUID application);
}
