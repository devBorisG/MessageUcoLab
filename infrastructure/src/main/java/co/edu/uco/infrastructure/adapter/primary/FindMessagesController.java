package co.edu.uco.infrastructure.adapter.primary;

import co.edu.uco.core.application.dto.page.PageRequestDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface FindMessagesController {
        void findByEnvironmentAndMessage(PageRequestDTO pageRequestDTO, HttpServletRequest httpServletRequest,
                                         HttpServletResponse httpServletResponse);
        void findByCodeMessageAndEnvironment(String messageCode, HttpServletRequest httpServletRequest,
                        HttpServletResponse httpServletResponse);
}