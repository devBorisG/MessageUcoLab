package co.edu.uco.infrastructure.adapter.primary.interceptors;

import co.edu.uco.infrastructure.adapter.secondary.presenter.serializer.SerializerRegistry;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
@Order(2)
@Slf4j
public class TokenHeaderInterceptor implements HandlerInterceptor {

    private final SerializerRegistry serializerRegistry;

    public TokenHeaderInterceptor(SerializerRegistry serializerRegistry) {
        this.serializerRegistry = serializerRegistry;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        var token = request.getHeader("Token");
        var acceptHeader = request.getHeader("Accept");
        if (token == null || token.isBlank()) {
            response.setStatus(HttpStatus.UNAUTHORIZED.value());

            var serializer = serializerRegistry.getSerializerForMediaType(acceptHeader);

            response.setContentType(serializer.getSupportedContentType());
            response.getWriter().write("Token is required for this request");
            log.error("Token is required for this request: %s".formatted(request.getRequestURI()));
            return false;
        }


        return true;
    }
}
