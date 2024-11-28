package co.edu.uco.core.application.validator.impl;

import co.edu.uco.core.application.catalog.strategy.inmemory.enums.MessageKeyEnum;
import co.edu.uco.core.application.validator.Validator;
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
            throw BusinessRuleException.buildUserException(String.format(MessageKeyEnum.FUN_010.getKey(), value));
        }
    }
}