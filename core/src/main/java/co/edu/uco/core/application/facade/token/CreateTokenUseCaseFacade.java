package co.edu.uco.core.application.facade.token;

import co.edu.uco.core.application.dto.CreateTokenDTO;

public interface CreateTokenUseCaseFacade {
    String createToken(CreateTokenDTO tokenDTO, String application);
}
