package co.edu.uco.core.application.facade.token.impl;

import co.edu.uco.core.application.dto.CreateTokenDTO;
import co.edu.uco.core.application.dto.TokenDTO;
import co.edu.uco.core.application.dto.encrypt.KeyPairDTO;
import co.edu.uco.core.application.facade.token.CreateTokenUseCaseFacade;
import co.edu.uco.core.application.mapper.dto.impl.TokenDTOMapper;
import co.edu.uco.core.domain.port.out.secret.CreateTokenSecretPort;
import co.edu.uco.core.domain.port.out.secret.EncryptTokenPort;
import co.edu.uco.core.domain.usecase.handling.HandlingCreateTokenPort;
import co.edu.uco.utils.exception.CrossWordsException;
import co.edu.uco.utils.helper.UtilPairKey;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import co.edu.uco.utils.helper.UtilUUID;
import java.time.LocalDateTime;
import java.util.UUID;

import static co.edu.uco.core.CrosswordsConstant.TOKEN_SECRET_IDENTIFIER;

import static co.edu.uco.utils.helper.UtilText.concatenateWithoutSeparator;
import static co.edu.uco.utils.helper.UtilText.stringToUpperCase;

@Slf4j
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

    //TODO: Eliminar codigo hardcodeado
    @Override
    public String createToken(
            CreateTokenDTO createTokenDTO,
            UUID application
    ) {
        String secretName = concatenateWithoutSeparator(
                TOKEN_SECRET_IDENTIFIER,
                stringToUpperCase(UtilUUID.formatUUID(application)),
                stringToUpperCase(UtilUUID.formatUUID(createTokenDTO.getEnvironmentId()))
        );

        KeyPairDTO keyPairResponseDTO = encrypt.generateKeys();

        if(keyPairResponseDTO == null) {
            log.error("KeyPair generation failed");
            throw CrossWordsException.build("Error generating keys");
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
            log.error("Error generating token", e);
            throw CrossWordsException.build("Error generating token");
        }
    }
}
