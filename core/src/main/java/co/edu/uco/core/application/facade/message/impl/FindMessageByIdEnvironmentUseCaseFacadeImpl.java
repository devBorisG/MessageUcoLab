package co.edu.uco.core.application.facade.message.impl;

import co.edu.uco.core.application.dto.MessageDTO;
import co.edu.uco.core.application.facade.message.FindMessageByIdEnvironmentUseCaseFacade;
import co.edu.uco.core.domain.port.out.repository.SimplePage;
import co.edu.uco.core.domain.port.out.repository.SimplePageRequest;
import co.edu.uco.core.domain.usecase.handling.HandlingFindMessageByIdEnvironmentPort;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Component
@Transactional
public class FindMessageByIdEnvironmentUseCaseFacadeImpl implements FindMessageByIdEnvironmentUseCaseFacade {
    private final HandlingFindMessageByIdEnvironmentPort handlingFindMessageByIdEnvironmentPort;

    public FindMessageByIdEnvironmentUseCaseFacadeImpl(
            HandlingFindMessageByIdEnvironmentPort handlingFindMessageByIdEnvironmentPort) {
        this.handlingFindMessageByIdEnvironmentPort = handlingFindMessageByIdEnvironmentPort;
    }

    @Override
    public SimplePage<MessageDTO> execute(UUID id, SimplePageRequest pageRequest) {
        return handlingFindMessageByIdEnvironmentPort.execute(id, pageRequest);
    }
}