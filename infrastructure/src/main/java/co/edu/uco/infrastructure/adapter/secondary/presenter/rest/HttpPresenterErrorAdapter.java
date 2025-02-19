package co.edu.uco.infrastructure.adapter.secondary.presenter.rest;

import co.edu.uco.core.application.catalog.strategy.inmemory.enums.DetailMessageEnum;
import co.edu.uco.core.domain.port.out.Response;
import co.edu.uco.utils.exception.CrossWordsException;
import co.edu.uco.infrastructure.adapter.secondary.presenter.serializer.SerializerRegistry;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static co.edu.uco.infrastructure.configuration.InfrastructureConstant.REQUEST_GET_HEADER_ACCEPT;

@Slf4j
@RestControllerAdvice
public final class HttpPresenterErrorAdapter<T> {
    private final SerializerRegistry serializerRegistry;
    public HttpPresenterErrorAdapter(SerializerRegistry serializerRegistry) {
        this.serializerRegistry = serializerRegistry;
    }

    @ExceptionHandler(CrossWordsException.class)
    public void presentCrossWordsException(
            CrossWordsException ex,
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        try {
            var acceptHeader = Optional.ofNullable(request.getHeader(REQUEST_GET_HEADER_ACCEPT))
                    .orElse(MediaType.APPLICATION_JSON_VALUE);
            var serializer = serializerRegistry.getSerializerForMediaType(acceptHeader);
            var message = Optional.ofNullable(ex.getUserMessage())
                    .filter(msg -> !msg.isEmpty())
                    .orElseGet(() -> {
                        log.error(DetailMessageEnum.TCH_016.getContent(), ex);
                        return DetailMessageEnum.FUN_023.getContent();
                    });
            var responseError = new Response<>(List.of(), List.of(message));
            var formattedResponse = serializer.serialize(responseError);
            response.setStatus(HttpStatus.NOT_FOUND.value());
            response.setContentType(serializer.getSupportedContentType());
            response.getWriter().write(formattedResponse);
            log.error(DetailMessageEnum.TCH_020.getContent(), formattedResponse);
        } catch (IOException | CrossWordsException exception) {
            log.error(DetailMessageEnum.TCH_019.getContent(), exception);
            throw exception;
        }
    }

    @ExceptionHandler(Exception.class)
    public void handleGeneralException(
            Exception ex,
            HttpServletRequest request,
            HttpServletResponse response
    ) {
        try {
            var acceptHeader = Optional.ofNullable(request.getHeader(REQUEST_GET_HEADER_ACCEPT))
                    .orElse(MediaType.APPLICATION_JSON_VALUE);
            var serializer = serializerRegistry.getSerializerForMediaType(acceptHeader);
            var responseError = new Response<>(List.of(), List.of(ex.getMessage()));
            var formattedResponse = serializer.serialize(responseError);
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            response.setContentType(serializer.getSupportedContentType());
            response.getWriter().write(formattedResponse);
            log.error(DetailMessageEnum.TCH_020.getContent(), formattedResponse);
        } catch (IOException ioEx) {
            log.error(DetailMessageEnum.TCH_019.getContent(), ioEx);
        }
    }
}