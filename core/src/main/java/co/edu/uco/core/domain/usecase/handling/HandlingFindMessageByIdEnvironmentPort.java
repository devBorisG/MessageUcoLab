package co.edu.uco.core.domain.usecase.handling;

import co.edu.uco.core.application.dto.MessageDTO;
import co.edu.uco.core.domain.port.out.repository.SimplePage;
import co.edu.uco.core.domain.port.out.repository.SimplePageRequest;

import java.util.UUID;

public interface HandlingFindMessageByIdEnvironmentPort {
    SimplePage<MessageDTO> execute(UUID id, SimplePageRequest pageRequest);
}