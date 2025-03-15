package co.edu.uco.infrastructure.adapter.primary;

import co.edu.uco.core.domain.port.out.repository.SimplePageRequest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.UUID;

public interface FindMessagesController {
        void findByEnvironmentAndMessage(SimplePageRequest simplePageRequest, HttpServletRequest httpServletRequest,
                        HttpServletResponse httpServletResponse);

        void findByCodeMessageAndEnvironment(String messageCode, HttpServletRequest httpServletRequest,
                        HttpServletResponse httpServletResponse);

        void findByIdEnvironment(UUID id, SimplePageRequest simplePageRequest, HttpServletRequest httpServletRequest,
                        HttpServletResponse httpServletResponse);
}