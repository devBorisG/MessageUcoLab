package co.edu.uco.core.application.validator.page;

import co.edu.uco.core.application.validator.Validator;
import co.edu.uco.core.domain.port.out.repository.SimplePageRequest;
import co.edu.uco.utils.exception.BusinessRuleException;

import java.util.Arrays;
import java.util.List;

public final class SimplePageRequestValidator implements Validator<SimplePageRequest> {
    private final List<Validator<SimplePageRequest>> validators;
    public SimplePageRequestValidator(Class<?> modelClass) {
        this.validators = Arrays.asList(
                new PageSizeValidator(),
                new PageNumberValidator(),
                new SortDirectionValidator(),
                new SortColumnValidator(modelClass)
        );
    }
    @Override
    public void validate(SimplePageRequest data) throws BusinessRuleException {
        for (Validator<SimplePageRequest> validator : validators) {
            validator.validate(data);
        }
    }
}