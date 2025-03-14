package co.edu.uco.infrastructure.configuration;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@WritingConverter
@Component
public final class LocalDateTimeToLongConverter implements Converter<LocalDateTime, Long> {
    @Override
    public Long convert(LocalDateTime source) {
        return source.toInstant(ZoneOffset.UTC).toEpochMilli() * 1_000;
    }
}