package co.edu.uco.infrastructure.adapter.primary;

import co.edu.uco.core.domain.port.out.repository.SimplePageRequest;
import jakarta.servlet.http.HttpServletRequest;

public interface ListMessageByApplicationController {
    void execute(String application, SimplePageRequest request, HttpServletRequest httpServletRequest);
}