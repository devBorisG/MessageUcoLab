package co.edu.uco.infrastructure.adapter.primary.controller;

import java.util.Optional;
import java.util.UUID;

import co.edu.uco.core.application.catalog.strategy.inmemory.enums.DetailMessageEnum;
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
        var correlationId = UUID.randomUUID().toString();
        var message = Optional.ofNullable(ex.getUserMessage())
                .filter(msg -> !msg.isEmpty())
                .orElseGet(() -> {
                    log.error(DetailMessageEnum.TCH_016.getContent(), correlationId, ex);
                    return DetailMessageEnum.FUN_012.getContent();
                });
        var responseError = new ResponseError(message, correlationId);
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(responseError);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseError> handleGeneralException(Exception ex){
        var correlationId = UUID.randomUUID().toString();
        log.error(DetailMessageEnum.TCH_016.getContent(), correlationId, ex);
        var responseError = new ResponseError(DetailMessageEnum.FUN_001.getContent(), correlationId);
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(responseError);
    }
}