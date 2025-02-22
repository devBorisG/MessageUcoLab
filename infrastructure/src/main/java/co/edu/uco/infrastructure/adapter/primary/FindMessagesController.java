package co.edu.uco.infrastructure.adapter.primary;

import co.edu.uco.core.domain.port.out.repository.SimplePageRequest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface FindMessagesController {
    void findByCodeMessageAndApplication(String codeMessage, String application, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse);

    void findByApplication(String application, SimplePageRequest simplePageRequest, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse);
}
