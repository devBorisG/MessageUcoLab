package co.edu.uco.infrastructure.adapter.secondary.presenter.rest;

import co.edu.uco.core.application.catalog.strategy.inmemory.enums.DetailMessageEnum;
import co.edu.uco.core.domain.port.out.Response;
import co.edu.uco.core.domain.port.out.presenter.PresenterPort;
import co.edu.uco.utils.exception.CrossWordsException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestControllerAdvice
public class HttpPresenterAdapter<T> implements PresenterPort<T> {

    private final HttpServletResponse response;

    public HttpPresenterAdapter(HttpServletResponse response) {
        this.response = response;
    }

    @Override
    public void presentRestSuccess(List<T> dto) {
        try {
            response.setStatus(HttpStatus.OK.value());
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);

            Response<T> responseBody = new Response<>(dto, Collections.emptyList());

            String json = new ObjectMapper().writeValueAsString(responseBody);
            response.getWriter().write(json);

            log.info("Respuesta exitosa: {}", json);
        } catch (IOException e) {
            log.error("Error al escribir la respuesta", e);
        }
    }

    @ExceptionHandler(CrossWordsException.class)
    public ResponseEntity<Response<T>> presentCrossWordsException(CrossWordsException ex) {
        var message = Optional.ofNullable(ex.getUserMessage())
                .filter(msg -> !msg.isEmpty())
                .orElseGet(() -> {
                    log.error(DetailMessageEnum.TCH_016.getContent(), ex);
                    return DetailMessageEnum.FUN_023.getContent();
                });
        var responseError = new Response<T>(List.of(),
                List.of(message));
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(responseError);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Response<T>> handleGeneralException(Exception ex){
        log.error(DetailMessageEnum.TCH_016.getContent(), ex);
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new Response<>(
                        List.of(),
                        List.of(ex.getMessage()))
                );
    }
}
