package co.edu.uco.core.domain.validator.page;

import co.edu.uco.core.application.catalog.strategy.inmemory.enums.DetailMessageEnum;
import co.edu.uco.core.application.dto.PageRequestDTO;
import co.edu.uco.core.domain.validator.Validator;
import co.edu.uco.utils.exception.BusinessRuleException;
import org.springframework.stereotype.Component;

import static co.edu.uco.utils.helper.UtilText.ONLY_NUMBERS;
import static co.edu.uco.utils.helper.UtilText.validMatch;

@Component
public final class PageRequestTypeValidator implements Validator<PageRequestDTO> {
    @Override
    public void validate(PageRequestDTO data) throws BusinessRuleException {
        if (data == null) {
            return; // Si es nulo, se usarán valores por defecto en el mapper
        }
        validatePage(data.getPage());
        validateSize(data.getSize());
    }
    /**
     * Valida que page sea un número entero válido
     */
    private void validatePage(String page) {
        if (page != null && !page.isEmpty() && !validMatch(page, ONLY_NUMBERS)) {
            throw BusinessRuleException.buildUserException(DetailMessageEnum.FUN_033.getContent());
        }
    }
    private void validateSize(String size) {
        if (size != null && !size.isEmpty() && !validMatch(size, ONLY_NUMBERS)) {
            throw BusinessRuleException.buildUserException(DetailMessageEnum.FUN_034.getContent());
        }
    }
} 