package co.edu.uco.infrastructure.adapter.primary.interceptors;

import co.edu.uco.core.domain.port.out.Response;
import co.edu.uco.core.domain.usecase.handling.HandlingVerifyAccessPort;
import co.edu.uco.infrastructure.adapter.secondary.presenter.serializer.SerializerRegistry;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.List;

import static co.edu.uco.infrastructure.configuration.InfrastructureConstant.REQUEST_GET_HEADER_ACCEPT;
import static co.edu.uco.infrastructure.configuration.InfrastructureConstant.REQUEST_GET_HEADER_TOKEN;

@Component
@Slf4j
public class TokenHeaderInterceptor implements HandlerInterceptor {

    private final SerializerRegistry serializerRegistry;
    private final HandlingVerifyAccessPort handlingVerifyAccessPort;

    public TokenHeaderInterceptor(SerializerRegistry serializerRegistry, HandlingVerifyAccessPort handlingVerifyAccessPort) {
        this.serializerRegistry = serializerRegistry;
        this.handlingVerifyAccessPort = handlingVerifyAccessPort;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        var token = request.getHeader(REQUEST_GET_HEADER_TOKEN);
        var acceptHeader = request.getHeader(REQUEST_GET_HEADER_ACCEPT);
        var serializer = serializerRegistry.getSerializerForMediaType(acceptHeader);
        if (handlingVerifyAccessPort.verifyAccess(token)) {
            return true;
        }
        var errorMessage = "Access denied, the token is invalid";
        var errorResponse = new Response<String>(List.of(), List.of(errorMessage));
        var formattedError = serializer.serialize(errorResponse);
        response.setStatus(HttpStatus.FORBIDDEN.value());
        response.setContentType(serializer.getSupportedContentType());
        response.getWriter().write(formattedError);
        return false;
    }
}
