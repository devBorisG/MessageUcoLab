package co.edu.uco.core.validator;

import java.util.ArrayList;
import java.util.List;

public final class CompositeValidator<T> implements Validator<T> {
    private final List<Validator<T>> validators = new ArrayList<>();
    public CompositeValidator<T> addValidator(List<Validator<T>> validators) {
        addValidator(validators);
        return this;
    }
    @Override
    public void validate(T data) {
        validators.forEach(validator -> validator.validate(data));
    }
}