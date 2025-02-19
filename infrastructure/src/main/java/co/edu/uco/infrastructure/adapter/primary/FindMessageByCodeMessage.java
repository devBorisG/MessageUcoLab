package co.edu.uco.infrastructure.adapter.primary;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface FindMessageByCodeMessage {
    void execute(String codeMessage, String application, HttpServletRequest request, HttpServletResponse response);
}
