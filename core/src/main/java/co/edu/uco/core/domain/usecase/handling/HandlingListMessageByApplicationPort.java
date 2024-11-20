package co.edu.uco.core.domain.usecase.handling;

import co.edu.uco.core.domain.port.out.repository.SimplePageRequest;

public interface HandlingListMessageByApplicationPort {
    void execute(String application, SimplePageRequest pageRequest);
}