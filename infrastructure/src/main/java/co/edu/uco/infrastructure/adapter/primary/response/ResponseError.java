package co.edu.uco.infrastructure.adapter.primary.response;

import java.time.LocalDate;

public record ResponseError(String error, String correlationId, LocalDate timestamp) {
}