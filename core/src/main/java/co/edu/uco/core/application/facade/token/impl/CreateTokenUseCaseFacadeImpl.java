package co.edu.uco.core.application.facade.token.impl;

import co.edu.uco.core.application.dto.CreateTokenDTO;
import co.edu.uco.core.application.dto.TokenDTO;
import co.edu.uco.core.application.facade.token.CreateTokenUseCaseFacade;
import co.edu.uco.core.application.mapper.dto.impl.TokenDTOMapper;
import co.edu.uco.core.domain.port.out.secret.CreateTokenSecretPort;
import co.edu.uco.core.domain.port.out.secret.EncryptionService;
import co.edu.uco.core.domain.usecase.handling.HandlingCreateTokenPort;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;
import co.edu.uco.utils.helper.UtilUUID;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
@Transactional
public class CreateTokenUseCaseFacadeImpl implements CreateTokenUseCaseFacade {

    private final HandlingCreateTokenPort handlingCreateTokenPort;
    private final TokenDTOMapper tokenDTOMapper;
    private final EncryptionService encryptionService;
    private final CreateTokenSecretPort createTokenSecretPort;

    public CreateTokenUseCaseFacadeImpl(
            HandlingCreateTokenPort handlingCreateTokenPort,
            TokenDTOMapper tokenDTOMapper,
            EncryptionService encryptionService,
            CreateTokenSecretPort createTokenSecretPort
    ) {
        this.handlingCreateTokenPort = handlingCreateTokenPort;
        this.tokenDTOMapper = tokenDTOMapper;
        this.encryptionService = encryptionService;
        this.createTokenSecretPort = createTokenSecretPort;
    }

    @Override
    public String createToken(
            CreateTokenDTO createTokenDTO,
            UUID application
    ) {
        TokenDTO tokenDTO = TokenDTO.builder()
                    .id(UtilUUID.getStringFromUUID(UtilUUID.getNewUUID()))
                    .creationDate(LocalDateTime.now())
                    .expirationDate(createTokenDTO.getExpirationDate())
                    .environmentId(createTokenDTO.getEnvironmentId())
                    .build();

        var token = tokenDTO.getId()
                .concat(UtilUUID.getStringFromUUID(application))
                .concat(UtilUUID.getStringFromUUID(tokenDTO.getEnvironmentId()));
        var tokenEncrypted = encryptionService.encrypt(token);
        tokenDTO.setId(encryptionService.encrypt(tokenDTO.getId()));
        createTokenSecretPort.execute(tokenDTO.getId(), tokenEncrypted);

        handlingCreateTokenPort.createToken(tokenDTOMapper.mapperDomain(tokenDTO));

        return tokenEncrypted;
    }
}
