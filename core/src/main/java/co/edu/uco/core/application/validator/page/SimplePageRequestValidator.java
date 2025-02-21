package co.edu.uco.core.application.validator.page;

import co.edu.uco.core.application.validator.CompositeValidator;
import co.edu.uco.core.domain.port.out.repository.SimplePageRequest;
import org.springframework.stereotype.Component;


@Component
public final class SimplePageRequestValidator {
    private final CompositeValidator<SimplePageRequest> compositeValidator;
    public SimplePageRequestValidator(CompositeValidator<SimplePageRequest> compositeValidator) {
        this.compositeValidator = compositeValidator;
    }
    public void validate(SimplePageRequest data) {
        compositeValidator.validate(data);
    }
}