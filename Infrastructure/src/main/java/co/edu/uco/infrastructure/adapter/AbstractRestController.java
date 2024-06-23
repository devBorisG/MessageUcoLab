package co.edu.uco.infrastructure.adapter;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public abstract class AbstractRestController {

    @ExceptionHandler
    public ResponseEntity<Map<String, String>> handleRestError(Exception e){
        return ResponseEntity
                            .status(HttpStatus.BAD_REQUEST)
                            .body(Map.of("error", e.getMessage()));
    }
}