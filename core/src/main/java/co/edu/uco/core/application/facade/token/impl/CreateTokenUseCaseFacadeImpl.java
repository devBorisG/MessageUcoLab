package co.edu.uco.core.application.facade.token.impl;

import co.edu.uco.core.application.dto.CreateTokenDTO;
import co.edu.uco.core.application.dto.TokenDTO;
import co.edu.uco.core.application.dto.encrypt.KeyPairResponseDTO;
import co.edu.uco.core.application.facade.token.CreateTokenUseCaseFacade;
import co.edu.uco.core.application.mapper.dto.impl.TokenDTOMapper;
import co.edu.uco.core.domain.port.out.secret.CreateTokenSecretPort;
import co.edu.uco.core.domain.port.out.secret.EncryptService;
import co.edu.uco.core.domain.port.out.secret.EncryptionService;
import co.edu.uco.core.domain.usecase.handling.HandlingCreateTokenPort;
import co.edu.uco.utils.helper.UtilPairKey;
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
    private final CreateTokenSecretPort createTokenSecretPort;
    private final EncryptService encrypt;
    private final EncryptionService encryptionService;

    public CreateTokenUseCaseFacadeImpl(
            HandlingCreateTokenPort handlingCreateTokenPort,
            TokenDTOMapper tokenDTOMapper,
            EncryptService encrypt,
            CreateTokenSecretPort createTokenSecretPort,
            EncryptionService encryptionService
    ) {
        this.handlingCreateTokenPort = handlingCreateTokenPort;
        this.tokenDTOMapper = tokenDTOMapper;
        this.encrypt = encrypt;
        this.createTokenSecretPort = createTokenSecretPort;
        this.encryptionService = encryptionService;
    }

    @Override
    public String createToken(
            CreateTokenDTO createTokenDTO,
            UUID application
    ) {
        var token = "UCOLAB_PK"
                .concat(
                        encryptionService.
                                encrypt(UtilUUID.getStringFromUUID(application))
                )
                .concat(
                        encryptionService.
                                encrypt(UtilUUID.getStringFromUUID(createTokenDTO.getEnvironmentId()))
                );

        KeyPairResponseDTO keyPairResponseDTO = encrypt.generateKeys();

        String privateKeyPEMFormatted = UtilPairKey.privateKeyFormatted(keyPairResponseDTO.getPrivateKey());

        TokenDTO tokenDTO = TokenDTO.builder()
                .id(keyPairResponseDTO.getPublicKey())
                .secretName(token)
                .creationDate(LocalDateTime.now())
                .expirationDate(createTokenDTO.getExpirationDate())
                .environmentId(createTokenDTO.getEnvironmentId())
                .build();

        createTokenSecretPort.execute(token, privateKeyPEMFormatted);

        handlingCreateTokenPort.createToken(tokenDTOMapper.mapperDomain(tokenDTO));

        return keyPairResponseDTO.getPublicKey();
    }
}
