package co.edu.uco.core.domain.validator.token;

import co.edu.uco.core.application.dto.CreateTokenDTO;
import co.edu.uco.core.domain.validator.environment.ApplicationBelongsEnvironmentValidator;
import co.edu.uco.core.domain.validator.environment.EnvironmentExistValidator;
import co.edu.uco.core.domain.validator.impl.ExpirationDateValidator;
import co.edu.uco.core.domain.validator.impl.UUIDValidator;
import org.springframework.stereotype.Component;

import static co.edu.uco.utils.helper.UtilDate.parseDate;
import static co.edu.uco.utils.helper.UtilUUID.getUUIDFromString;

@Component
public final class CreateTokenCompositeValidator {
    private final ApplicationBelongsEnvironmentValidator applicationBelongsEnvironmentValidator;
    private final EnvironmentExistValidator environmentExistValidator;
    private final ExpirationDateValidator expirationDateValidator;
    private final DateisValidValidator dateisValidValidator;
    private final UUIDValidator uuidValidator;
    public CreateTokenCompositeValidator(ApplicationBelongsEnvironmentValidator applicationBelongsEnvironmentValidator, EnvironmentExistValidator environmentExistValidator, ExpirationDateValidator expirationDateValidator, DateisValidValidator dateisValidValidator, UUIDValidator uuidValidator) {
        this.applicationBelongsEnvironmentValidator = applicationBelongsEnvironmentValidator;
        this.environmentExistValidator = environmentExistValidator;
        this.expirationDateValidator = expirationDateValidator;
        this.dateisValidValidator = dateisValidValidator;
        this.uuidValidator = uuidValidator;
    }
    public void validate(CreateTokenDTO createTokenDTO, String applicationId) {
        uuidValidator.validate(applicationId);
        uuidValidator.validate(createTokenDTO.getEnvironmentId());
        dateisValidValidator.validate(createTokenDTO.getExpirationDate());
        expirationDateValidator.validate(parseDate(createTokenDTO.getExpirationDate()));
        environmentExistValidator.validate(createTokenDTO);
        applicationBelongsEnvironmentValidator.validate(getUUIDFromString(createTokenDTO.getEnvironmentId()),getUUIDFromString(applicationId));
    }
}