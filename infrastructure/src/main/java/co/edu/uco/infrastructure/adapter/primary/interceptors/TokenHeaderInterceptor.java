package co.edu.uco.infrastructure.adapter.primary.interceptors;

import co.edu.uco.core.application.catalog.strategy.inmemory.enums.DetailMessageEnum;
import co.edu.uco.core.application.facade.token.VerifyAccessUseCaseFacade;
import co.edu.uco.core.domain.port.out.Response;
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
import static co.edu.uco.utils.helper.UtilText.isEmptyOrNull;

@Component
@Slf4j
public final class TokenHeaderInterceptor implements HandlerInterceptor {
    private final SerializerRegistry serializerRegistry;
    private final VerifyAccessUseCaseFacade verifyAccessUseCaseFacade;
    public TokenHeaderInterceptor(SerializerRegistry serializerRegistry, VerifyAccessUseCaseFacade verifyAccessUseCaseFacade) {
        this.serializerRegistry = serializerRegistry;
        this.verifyAccessUseCaseFacade = verifyAccessUseCaseFacade;
    }
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        var token = request.getHeader(REQUEST_GET_HEADER_TOKEN);
        var acceptHeader = request.getHeader(REQUEST_GET_HEADER_ACCEPT);
        var serializer = serializerRegistry.getSerializerForMediaType(acceptHeader);
        var errorMessage = DetailMessageEnum.TCH_031.getContent();
        boolean isAccept = false;
        if (isEmptyOrNull(token)) {
            errorMessage = DetailMessageEnum.TCH_032.getContent();
        }
        var errorResponse = new Response<String>(List.of(), List.of(errorMessage));
        var formattedError = serializer.serialize(errorResponse);
        response.setStatus(HttpStatus.FORBIDDEN.value());
        response.setContentType(serializer.getSupportedContentType());
        response.getWriter().write(formattedError);
        if (!isEmptyOrNull(token) && verifyAccessUseCaseFacade.verifyAccess(token)) {
            isAccept = true;
        }
        return isAccept;
    }
}