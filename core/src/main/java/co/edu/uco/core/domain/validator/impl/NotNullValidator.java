package co.edu.uco.core.domain.validator.impl;

import co.edu.uco.core.application.catalog.strategy.inmemory.enums.DetailMessageEnum;
import co.edu.uco.core.domain.validator.Validator;
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
            throw BusinessRuleException.buildUserException(String.format(DetailMessageEnum.FUN_010.getContent(), value));
        }
    }
}