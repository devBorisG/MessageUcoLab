package co.edu.uco.infrastructure.adapter.primary;

import co.edu.uco.core.domain.port.out.repository.SimplePageRequest;

public interface ListMessageByApplicationController {
    void execute(String application, SimplePageRequest request);
}