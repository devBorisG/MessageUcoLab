package co.edu.uco.core.application.facade.message.impl;

import co.edu.uco.core.application.dto.MessageDTO;
import co.edu.uco.core.application.facade.message.FindMessageByCodeAndEnvironmentUseCaseFacade;
import co.edu.uco.core.domain.usecase.handling.HandlingFindMessageByCodeAndEnvironmentPort;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class FindMessageByCodeAndEnvironmentUseCaseFacadeImpl implements FindMessageByCodeAndEnvironmentUseCaseFacade {
    private final HandlingFindMessageByCodeAndEnvironmentPort handlingFindMessageByCodeAndEnvironmentPort;
    public FindMessageByCodeAndEnvironmentUseCaseFacadeImpl(
            HandlingFindMessageByCodeAndEnvironmentPort handlingFindMessageByCodeAndEnvironmentPort) {
        this.handlingFindMessageByCodeAndEnvironmentPort = handlingFindMessageByCodeAndEnvironmentPort;
    }
    @Override
    public MessageDTO execute(String messageCode, String environmentId) {
        return handlingFindMessageByCodeAndEnvironmentPort.execute(messageCode, environmentId);
    }
}