package co.edu.uco.infrastructure.configuration;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.stereotype.Component;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@ReadingConverter
@Component
public final class LongToLocalDateTimeConverter implements Converter<Long, LocalDateTime> {
    @Override
    public LocalDateTime convert(Long source) {
        // Convertir nanosegundos a microsegundos antes de convertir a LocalDateTime
        long millis = source / 1_000; // Convertimos de microsegundos a milisegundos
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(millis), ZoneOffset.UTC);
    }
}