package co.edu.uco.infrastructure.adapter.secondary.presenter.rest;

import co.edu.uco.core.application.catalog.strategy.inmemory.enums.DetailMessageEnum;
import co.edu.uco.core.domain.port.out.Response;
import co.edu.uco.core.domain.port.out.presenter.PresenterPort;
import co.edu.uco.utils.exception.CrossWordsException;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@RestControllerAdvice
@Getter
public final class RestPresenterImpl<T> implements PresenterPort<T> {
    private ResponseEntity<Response<T>> response;
    @Override
    public void presentRestSuccess(List<T> dto) {
        response = ResponseEntity.ok()
                .body(new Response<>(dto, Collections.emptyList()));
        log.info(Objects.requireNonNull(response.getBody()).data().toString());
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