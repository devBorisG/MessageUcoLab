package co.edu.uco.core.application.mapper.dto.impl;

import co.edu.uco.core.application.dto.PageRequestDTO;
import co.edu.uco.core.domain.port.out.repository.SimplePageRequest;
import co.edu.uco.utils.exception.BusinessRuleException;
import org.springframework.stereotype.Component;

@Component
public class SimplePageRequestMapper {

    public SimplePageRequest toDomain(PageRequestDTO request) {
        int pageInt = parseIntOrThrow(request.getPage(), "page");
        int sizeInt = parseIntOrThrow(request.getSize(), "size");
        return new SimplePageRequest(pageInt, request.getSort(), request.getColumnSort(), sizeInt);
    }

    private int parseIntOrThrow(String value, String field) {
        if (value == null || value.trim().isEmpty()) {
          //  return defaultValue;
        }
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw BusinessRuleException.buildUserException(field, "Debe ser un número entero válido");
        }
    }
}
