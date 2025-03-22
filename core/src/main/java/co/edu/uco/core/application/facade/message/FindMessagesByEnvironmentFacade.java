package co.edu.uco.core.application.facade.message;

import co.edu.uco.core.application.dto.MessageDTO;
import co.edu.uco.core.application.dto.PageRequestDTO;
import co.edu.uco.core.application.facade.page.impl.SimplePageFacadeImpl;
import co.edu.uco.core.domain.port.out.repository.SimplePage;
import co.edu.uco.core.domain.port.out.repository.SimplePageRequest;
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
        // Procesar la solicitud de paginación para convertir de PageRequestDTO a SimplePageRequest
        SimplePageRequest pageRequest = simplePageFacadeImpl.execute(pageDTO);
        // Ejecutar la búsqueda con los parámetros validados y convertidos
        return handlingFindMessageEnvironmentPort.execute(environmentId, pageRequest);
    }
}