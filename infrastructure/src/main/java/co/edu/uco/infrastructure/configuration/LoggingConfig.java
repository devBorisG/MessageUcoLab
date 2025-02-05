package co.edu.uco.infrastructure.configuration;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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
        var correlationId = request.getHeader(CORRELATION_ID);
        if (correlationId == null || correlationId.isEmpty()) {
            correlationId = UUID.randomUUID().toString();
        }

        var timestamp = TIMESTAMP_FORMAT.format(Instant.now());
        var threadName = Thread.currentThread().getName();
        var className = handler.getClass().getSimpleName();

        MDC.put(CORRELATION_ID, correlationId);
        MDC.put(LOGGING_REQUEST_URI, request.getRequestURI());
        MDC.put(LOGGING_HTTP_METHOD, request.getMethod());
        MDC.put(LOGGING_SESSION_ID, request.getSession().getId());
        MDC.put(LOGGING_QUERY_STRING, request.getQueryString());
        MDC.put(LOGGING_PARAMETER_CODE_MESSAGE,request.getParameter(LOGGING_PARAMETER_CODE_MESSAGE));
        MDC.put(LOGGING_PARAMETER_APPLICATION,request.getParameter(LOGGING_PARAMETER_APPLICATION));

        response.setHeader(CORRELATION_ID, correlationId);
        response.setHeader(LOGGING_TIMESTAMP, timestamp);
        response.setHeader(LOGGING_THREAD, threadName);
        response.setHeader(LOGGING_APP_NAME, LOGGING_PARAMETER_APPLICATION_NAME );
        response.setHeader(LOGGING_TRACE_ID, correlationId);

        return true;
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception exception) {
        MDC.clear();
    }
}