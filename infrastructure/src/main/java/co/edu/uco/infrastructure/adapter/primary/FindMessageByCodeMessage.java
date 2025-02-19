package co.edu.uco.infrastructure.adapter.primary;

import jakarta.servlet.http.HttpServletRequest;

public interface FindMessageByCodeMessage {
    void execute(String codeMessage, String application, HttpServletRequest request);
}
