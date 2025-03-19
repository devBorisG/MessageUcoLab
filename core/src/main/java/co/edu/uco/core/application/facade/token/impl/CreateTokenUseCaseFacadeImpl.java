package co.edu.uco.core.application.facade.token.impl;

import co.edu.uco.core.application.catalog.strategy.inmemory.enums.DetailMessageEnum;
import co.edu.uco.core.application.dto.CreateTokenDTO;
import co.edu.uco.core.application.dto.TokenDTO;
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

import static co.edu.uco.utils.helper.UtilObject.isNullObject;
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
    @Override
    public String createToken(
            CreateTokenDTO createTokenDTO,
            UUID application
    ) {
        var secretName = concatenateWithoutSeparator(
                TOKEN_SECRET_IDENTIFIER,
                stringToUpperCase(UtilUUID.formatUUID(application)),
                stringToUpperCase(UtilUUID.formatUUID(createTokenDTO.getEnvironmentId()))
        );

        var keyPairResponseDTO = encrypt.generateKeys();

        if(isNullObject(keyPairResponseDTO)){
            var message = DetailMessageEnum.TCH_024.getMessage();
            log.error(message.content());
            throw CrossWordsException.build(message.content());
        }

        try{
            var generateSignature = encrypt.generateSignature(secretName, keyPairResponseDTO.getPublicKey());

            var tokenDTO = TokenDTO.builder()
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
            var message = DetailMessageEnum.TCH_025.getContent();
            log.error(message, e);
            throw CrossWordsException.build(message, e);
        }
    }
}