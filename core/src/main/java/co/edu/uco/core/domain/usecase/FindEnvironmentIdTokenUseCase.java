package co.edu.uco.core.domain.usecase;

import co.edu.uco.core.domain.port.out.repository.token.FindTokenRepository;
import co.edu.uco.core.domain.usecase.handling.HandlingFindEnvironmentIdTokenPort;
import org.springframework.stereotype.Component;

@Component
public class FindEnvironmentIdTokenUseCase implements HandlingFindEnvironmentIdTokenPort {

    private final FindTokenRepository findTokenRepository;

    public FindEnvironmentIdTokenUseCase(FindTokenRepository findTokenRepository) {
        this.findTokenRepository = findTokenRepository;
    }

    @Override
    public String execute(String token) {
        try{
            var tokenData = findTokenRepository.findById(token);
            return tokenData != null ? tokenData.getEnvironmentId() : null;
        }catch (Exception e){
            throw new RuntimeException("Error al buscar el token");
        }
    }
}
