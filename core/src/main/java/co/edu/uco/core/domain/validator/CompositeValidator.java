package co.edu.uco.core.domain.validator;

import co.edu.uco.core.domain.validator.impl.NotNullValidator;
import co.edu.uco.utils.exception.CrossWordsException;
import co.edu.uco.utils.helper.UtilObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static co.edu.uco.utils.helper.UtilObject.isNullObject;

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
            throw CrossWordsException.build("No validators have been added.");
        }
        if (isNullObject(data)) {
            throw CrossWordsException.build("Data is null.");
        }
        validators.forEach(validator -> validator.validate(data));
    }
}