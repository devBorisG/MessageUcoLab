package co.edu.uco.core.application.facade.token.impl;

import co.edu.uco.core.application.facade.token.FindEnvironmentIdTokenUseCaseFacade;
import co.edu.uco.core.domain.usecase.handling.HandlingFindEnvironmentIdTokenPort;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class FindEnvironmentIdTokenUseCaseFacadeImpl implements FindEnvironmentIdTokenUseCaseFacade {
    private final HandlingFindEnvironmentIdTokenPort handlingFindEnvironmentIdTokenPort;
    public FindEnvironmentIdTokenUseCaseFacadeImpl(HandlingFindEnvironmentIdTokenPort handlingFindEnvironmentIdTokenPort) {
        this.handlingFindEnvironmentIdTokenPort = handlingFindEnvironmentIdTokenPort;
    }
    @Override
    public String findEnvironmentIdToken(String token) {
        return handlingFindEnvironmentIdTokenPort.execute(token);
    }
}