package co.edu.uco.infrastructure.adapter.primary.controller;

import java.util.Map;
import java.util.Optional;

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
    public ResponseEntity<Map<String, String>> handleCrossWordsException(CrossWordsException ex) {
        String message = Optional.ofNullable(ex.getUserMessage())
                .filter(msg -> !msg.isEmpty())
                .orElseGet(() -> {
                    log.error("Error de validación: {}", ex.getTechnicalMessage());
                    return "Ocurrió un error inesperado.";
                });

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(Map.of("error", message));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> handleGeneralException(Exception ex){
        log.error("Error de validación", ex);
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(Map.of("error", "Ocurrió un error inesperado."));
    }
}
