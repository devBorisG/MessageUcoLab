package co.edu.uco.core.domain.validator;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Component
public final class CompositeValidator<T> implements Validator<T> {
    private final List<Validator<T>> validators;
    @Autowired
    public CompositeValidator(List<Validator<T>> validators) {
        this.validators = validators;
    }
    @Override
    public void validate(T data) {
        if (validators.isEmpty()) {
            throw new IllegalStateException("No validators have been added.");
        }
        validators.forEach(validator -> validator.validate(data));
    }
}