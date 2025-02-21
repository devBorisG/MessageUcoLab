package co.edu.uco.core.application.validator.message;

import co.edu.uco.core.application.dto.MessageDTO;
import co.edu.uco.core.application.validator.page.SimplePageRequestValidator;
import co.edu.uco.core.application.validator.page.SortColumnValidator;
import co.edu.uco.core.domain.port.out.repository.SimplePageRequest;
import org.springframework.stereotype.Component;

@Component
public final class ListMessageValidator {
    private final SimplePageRequestValidator simplePageRequestValidator;
    private final SortColumnValidator sortColumnValidator = SortColumnValidator.getInstance(MessageDTO.class);
    public ListMessageValidator(SimplePageRequestValidator simplePageRequestValidator) {
        this.simplePageRequestValidator = simplePageRequestValidator;
    }
    public void validate(SimplePageRequest data) {
        simplePageRequestValidator.validate(data, MessageDTO.class);
        sortColumnValidator.validate(data);
    }
}