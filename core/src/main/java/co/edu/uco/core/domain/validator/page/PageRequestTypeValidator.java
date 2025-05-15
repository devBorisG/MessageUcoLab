package co.edu.uco.core.domain.validator.page;

import co.edu.uco.core.application.catalog.strategy.inmemory.enums.DetailMessageEnum;
import co.edu.uco.core.application.dto.page.PageRequestDTO;
import co.edu.uco.core.domain.validator.Validator;
import co.edu.uco.utils.exception.BusinessRuleException;
import org.springframework.stereotype.Component;

import static co.edu.uco.core.CrosswordsConstant.PAGE_ATTRIBUTE;
import static co.edu.uco.core.CrosswordsConstant.SIZE_ATTRIBUTE;
import static co.edu.uco.utils.helper.UtilObject.isNullObject;
import static co.edu.uco.utils.helper.UtilText.ONLY_NUMBERS;
import static co.edu.uco.utils.helper.UtilText.validMatch;

@Component
public final class PageRequestTypeValidator implements Validator<PageRequestDTO> {
    @Override
    public void validate(PageRequestDTO data) throws BusinessRuleException {
        if (isNullObject(data)) {
            return;
        }
        validatePage(data.getPage());
        validateSize(data.getSize());
    }
    private void validatePage(String page) {
        if (!isNullObject(page) && !page.isEmpty() && !validMatch(page, ONLY_NUMBERS)) {
            throw BusinessRuleException.buildUserException(String.format(DetailMessageEnum.FUN_033.getContent(), PAGE_ATTRIBUTE));
        }
    }
    private void validateSize(String size) {
        if (!isNullObject(size) && !size.isEmpty() && !validMatch(size, ONLY_NUMBERS)) {
            throw BusinessRuleException.buildUserException(String.format(DetailMessageEnum.FUN_033.getContent(),SIZE_ATTRIBUTE));
        }
    }
} 