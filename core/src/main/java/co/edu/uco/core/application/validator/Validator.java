package co.edu.uco.core.application.validator;

import co.edu.uco.utils.exception.BusinessRuleException;

public interface Validator<D> {
    void validate(D data) throws BusinessRuleException;
}