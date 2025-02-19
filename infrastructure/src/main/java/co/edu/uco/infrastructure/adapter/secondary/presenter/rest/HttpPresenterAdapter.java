package co.edu.uco.infrastructure.adapter.secondary.presenter.rest;

import co.edu.uco.core.application.catalog.strategy.inmemory.enums.DetailMessageEnum;
import co.edu.uco.core.domain.port.out.Response;
import co.edu.uco.core.domain.port.out.presenter.PresenterPort;
import co.edu.uco.infrastructure.adapter.secondary.presenter.serializer.SerializerRegistry;
import co.edu.uco.infrastructure.adapter.secondary.presenter.serializer.SerializerType;
import co.edu.uco.utils.exception.CrossWordsException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static co.edu.uco.infrastructure.configuration.InfrastructureConstant.REQUEST_GET_HEADER_ACCEPT;

@Slf4j
@Component
public final class HttpPresenterAdapter<T> implements PresenterPort<T> {
    private final SerializerRegistry serializerRegistry;
    public HttpPresenterAdapter(SerializerRegistry serializerRegistry) {
        this.serializerRegistry = serializerRegistry;
    }
    @Override
    public void presentRestSuccess(
            List<T> dto,
            HttpServletRequest  request,
            HttpServletResponse response
    ) {
        try {
            var acceptHeader = Optional.ofNullable(request.getHeader(REQUEST_GET_HEADER_ACCEPT))
                    .orElse(MediaType.APPLICATION_JSON_VALUE);
            var serializer = serializerRegistry.getSerializerForMediaType(acceptHeader);
            var responseBody = new Response<>(dto, Collections.emptyList());
            var formattedResponse = serializer.serialize(responseBody);
            response.setStatus(HttpStatus.OK.value());
            response.setContentType(serializer.getSupportedContentType());
            response.getWriter().write(formattedResponse);
            log.info("Respuesta exitosa: {}", formattedResponse);
        } catch (CrossWordsException | IOException ex) {
            log.error(DetailMessageEnum.TCH_016.getContent(), ex);
        }
    }
}