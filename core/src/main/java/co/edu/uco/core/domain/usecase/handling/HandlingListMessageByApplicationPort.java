package co.edu.uco.core.domain.usecase.handling;

import co.edu.uco.core.application.dto.MessageDTO;
import co.edu.uco.core.domain.port.out.repository.SimplePage;
import co.edu.uco.core.domain.port.out.repository.SimplePageRequest;

public interface HandlingListMessageByApplicationPort {
    void execute(String application, SimplePageRequest pageRequest);
}