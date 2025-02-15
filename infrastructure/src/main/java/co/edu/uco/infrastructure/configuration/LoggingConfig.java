package co.edu.uco.infrastructure.configuration;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import static co.edu.uco.infrastructure.configuration.InfrastructureConstant.*;

@Component
public final class LoggingConfig implements HandlerInterceptor {
    private static final DateTimeFormatter TIMESTAMP_FORMAT = DateTimeFormatter
            .ofPattern(PATTERN_TIMESTAMP_FORMAT)
            .withZone(ZoneOffset.UTC);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        // Capturar Correlation-ID del header o generar uno
        String correlationId = request.getHeader(CORRELATION_ID);
        if (correlationId == null || correlationId.isEmpty()) {
            correlationId = UUID.randomUUID().toString();
        }

        // Establecer valores en MDC
        MDC.put(CORRELATION_ID, correlationId);
        MDC.put(LOGGING_REQUEST_URI, request.getRequestURI());
        MDC.put(LOGGING_HTTP_METHOD, request.getMethod());

        // Evitar crear sesión si no existe
        HttpSession session = request.getSession(true);
        MDC.put(LOGGING_SESSION_ID, session.getId());

        // Manejar parámetros opcionales sin nulls
        putMDCIfNotNull(LOGGING_QUERY_STRING, request.getQueryString());
        putMDCIfNotNull(LOGGING_PARAMETER_CODE_MESSAGE, request.getParameter(LOGGING_PARAMETER_CODE_MESSAGE));
        putMDCIfNotNull(LOGGING_PARAMETER_APPLICATION, request.getParameter(LOGGING_PARAMETER_APPLICATION));

        // Configurar headers de respuesta
        response.setHeader(CORRELATION_ID, correlationId);
        response.setHeader(LOGGING_TIMESTAMP, TIMESTAMP_FORMAT.format(Instant.now()));
        response.setHeader(LOGGING_THREAD, Thread.currentThread().getName());
        response.setHeader(LOGGING_APP_NAME, LOGGING_PARAMETER_APPLICATION_NAME);

        return true;
    }

    private void putMDCIfNotNull(String key, String value) {
        if (value != null && !value.isEmpty()) {
            MDC.put(key, value);
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        MDC.clear(); // Limpiar MDC al finalizar la petición
    }
}