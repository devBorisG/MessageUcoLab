package co.edu.uco.infrastructure.adapter.primary.controller;

import java.util.Optional;
import java.util.UUID;

import co.edu.uco.infrastructure.adapter.primary.response.ResponseError;
import co.edu.uco.utils.exception.CrossWordsException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public abstract class AbstractRestController {

    @ExceptionHandler(CrossWordsException.class)
    public ResponseEntity<ResponseError> handleCrossWordsException(CrossWordsException ex) {
        String correlationId = UUID.randomUUID().toString();
        String message = Optional.ofNullable(ex.getUserMessage())
                .filter(msg -> !msg.isEmpty())
                .orElseGet(() -> {
                    log.error("Error de validación, Correlation ID: {}", correlationId, ex);
                    return "Ocurrió un error inesperado.";
                });
        ResponseError responseError = new ResponseError(message, correlationId);
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(responseError);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseError> handleGeneralException(Exception ex){
        String correlationId = UUID.randomUUID().toString();
        log.error("Error de validación, Correlation ID: {}", correlationId, ex);
        ResponseError responseError = new ResponseError("Ocurrió un error inesperado.", correlationId);
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(responseError);
    }
}
