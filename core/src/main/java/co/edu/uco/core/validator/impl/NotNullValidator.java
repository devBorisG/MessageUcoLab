package co.edu.uco.core.validator.impl;

import co.edu.uco.core.validator.Validator;
import co.edu.uco.utils.exception.BusinessRuleException;

import static co.edu.uco.utils.helper.UtilObject.isNullObject;

public final class NotNullValidator<T> implements Validator<T> {
    private final String value;
    public NotNullValidator(String value) {
        this.value = value;
    }
    @Override
    public void validate(T data) throws BusinessRuleException {
        if (isNullObject(data)) {
            throw BusinessRuleException.buildUserException(String.format("%s is required", value));
        }
    }
}