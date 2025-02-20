package co.edu.uco.core.application.validator.page;

import co.edu.uco.core.application.catalog.strategy.inmemory.enums.DetailMessageEnum;
import co.edu.uco.core.application.validator.Validator;
import co.edu.uco.core.domain.port.out.repository.SimplePageRequest;
import co.edu.uco.utils.exception.BusinessRuleException;

public final class PageNumberValidator implements Validator<SimplePageRequest> {
    private final int totalPages;
    public PageNumberValidator(int totalPages) {
        this.totalPages = totalPages;
    }
    @Override
    public void validate(SimplePageRequest data) throws BusinessRuleException {
        if (data.getPage() < 1 || data.getPage() > totalPages) {
            throw BusinessRuleException.buildUserException(DetailMessageEnum.FUN_029.getContent());
        }
    }
}