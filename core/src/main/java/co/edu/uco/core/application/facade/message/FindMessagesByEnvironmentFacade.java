package co.edu.uco.core.application.facade.message;

import co.edu.uco.core.application.dto.MessageDTO;
import co.edu.uco.core.application.dto.PageRequestDTO;
import co.edu.uco.core.application.facade.page.impl.SimplePageFacadeImpl;
import co.edu.uco.core.domain.port.out.repository.SimplePage;
import co.edu.uco.core.domain.usecase.handling.HandlingFindMessageEnvironmentPort;
import org.springframework.stereotype.Component;

@Component
public final class FindMessagesByEnvironmentFacade {
    private final HandlingFindMessageEnvironmentPort handlingFindMessageEnvironmentPort;
    private final SimplePageFacadeImpl simplePageFacadeImpl;
    public FindMessagesByEnvironmentFacade(
            HandlingFindMessageEnvironmentPort handlingFindMessageEnvironmentPort,
            SimplePageFacadeImpl simplePageFacadeImpl) {
        this.handlingFindMessageEnvironmentPort = handlingFindMessageEnvironmentPort;
        this.simplePageFacadeImpl = simplePageFacadeImpl;
    }
    public SimplePage<MessageDTO> execute(String environmentId, PageRequestDTO pageDTO) {
        var simplePageRequest = simplePageFacadeImpl.execute(pageDTO);
        return handlingFindMessageEnvironmentPort.execute(environmentId, simplePageRequest);
    }
}