package co.edu.uco.infrastructure.adapter.primary;

import jakarta.servlet.http.HttpServletResponse;

public interface ListMessageCacheController {
    void execute(String codeMessage, HttpServletResponse response);
}
