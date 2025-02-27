package co.edu.uco.core.application.facade.token.impl;

import co.edu.uco.core.application.dto.CreateTokenDTO;
import co.edu.uco.core.application.dto.TokenDTO;
import co.edu.uco.core.application.dto.encrypt.KeyPairDTO;
import co.edu.uco.core.application.facade.token.CreateTokenUseCaseFacade;
import co.edu.uco.core.application.mapper.dto.impl.TokenDTOMapper;
import co.edu.uco.core.domain.port.out.secret.CreateTokenSecretPort;
import co.edu.uco.core.domain.port.out.secret.EncryptTokenPort;
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
    private final EncryptTokenPort encrypt;

    public CreateTokenUseCaseFacadeImpl(
            HandlingCreateTokenPort handlingCreateTokenPort,
            TokenDTOMapper tokenDTOMapper,
            EncryptTokenPort encrypt,
            CreateTokenSecretPort createTokenSecretPort
    ) {
        this.handlingCreateTokenPort = handlingCreateTokenPort;
        this.tokenDTOMapper = tokenDTOMapper;
        this.encrypt = encrypt;
        this.createTokenSecretPort = createTokenSecretPort;
    }

    @Override
    public String createToken(
            CreateTokenDTO createTokenDTO,
            UUID application
    ) {
        var secretName = "UCOLAB_PK"
                .concat(
                        UtilUUID.formatUUID(application).toUpperCase()
                )
                .concat(
                        UtilUUID.formatUUID(createTokenDTO.getEnvironmentId()).toUpperCase()
                );

        KeyPairDTO keyPairResponseDTO = encrypt.generateKeys();

        if(keyPairResponseDTO == null) {
            throw new RuntimeException("Error generating keys");
        }

        try{
            var generateSignature = encrypt.generateSignature(secretName, keyPairResponseDTO.getPublicKey());

            TokenDTO tokenDTO = TokenDTO.builder()
                    .id(generateSignature)
                    .secretName(secretName)
                    .creationDate(LocalDateTime.now())
                    .expirationDate(createTokenDTO.getExpirationDate())
                    .environmentId(createTokenDTO.getEnvironmentId())
                    .build();

            createTokenSecretPort.execute(secretName, UtilPairKey.encodePrivateKey(keyPairResponseDTO.getPrivateKey()));

            handlingCreateTokenPort.createToken(tokenDTOMapper.mapperDomain(tokenDTO));

            return generateSignature;
        }catch (Exception e){
            throw new RuntimeException("Error generating signature", e);
        }
    }
}
