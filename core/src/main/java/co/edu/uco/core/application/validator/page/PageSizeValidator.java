package co.edu.uco.core.application.validator.page;

import co.edu.uco.core.application.catalog.strategy.inmemory.enums.DetailMessageEnum;
import co.edu.uco.core.application.validator.Validator;
import co.edu.uco.core.domain.port.out.repository.SimplePageRequest;
import co.edu.uco.utils.exception.BusinessRuleException;

import static co.edu.uco.core.CrosswordsConstant.REQUEST_PAGE_DEFAULT;

public final class PageSizeValidator implements Validator<SimplePageRequest> {
    private static final int MAX_PAGE_SIZE = 500;
    @Override
    public void validate(SimplePageRequest data) throws BusinessRuleException {
        if (data.getSize() < REQUEST_PAGE_DEFAULT || data.getSize() > MAX_PAGE_SIZE) {
            throw BusinessRuleException.buildUserException(String.format(DetailMessageEnum.FUN_026.getContent(), MAX_PAGE_SIZE));
        }
    }
}