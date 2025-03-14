package co.edu.uco.core.domain.usecase;

import co.edu.uco.core.application.catalog.strategy.inmemory.enums.DetailMessageEnum;
import co.edu.uco.core.domain.data.TokenData;
import co.edu.uco.core.domain.port.out.repository.token.FindTokenRepository;
import co.edu.uco.core.domain.port.out.repository.token.TokenStateRepository;
import co.edu.uco.core.domain.port.out.secret.EncryptTokenPort;
import co.edu.uco.core.domain.port.out.secret.FindSecretTokenPort;
import co.edu.uco.core.domain.usecase.handling.HandlingVerifyAccessPort;
import co.edu.uco.utils.exception.BusinessRuleException;
import org.springframework.stereotype.Service;

import java.util.Map;

import static co.edu.uco.core.CrosswordsConstant.*;

@Service
public final class VerifyAccessUseCase implements HandlingVerifyAccessPort {
    private final EncryptTokenPort encryptTokenPort;
    private final FindSecretTokenPort findSecretTokenPort;
    private final FindTokenRepository findTokenRepository;
    private final TokenStateRepository tokenStateRepository;
    public VerifyAccessUseCase(EncryptTokenPort encryptTokenPort, FindSecretTokenPort findSecretTokenPort, FindTokenRepository findTokenRepository, TokenStateRepository tokenStateRepository) {
        this.encryptTokenPort = encryptTokenPort;
        this.findSecretTokenPort = findSecretTokenPort;
        this.findTokenRepository = findTokenRepository;
        this.tokenStateRepository = tokenStateRepository;
    }
    @Override
    public boolean verifyAccess(String token) {
        var secretName = findTokenRepository.findById(token);
        stateValid(secretName.getStateId());
        Map<String, String> secret = findSecretTokenPort.findSecretToken(secretName.getSecretName());
        try{
            return encryptTokenPort.access(
                    secret.get(SECRET_PORT_PRIVATE_KEY),
                    token,
                    secret.get(SECRET_PORT_SECRET_NAME)
            );
        } catch (Exception e){
            return false;
        }
    }
    private void stateValid(String statusId) {
        var status = tokenStateRepository.findByStatus(statusId);
        if (!status.getName().equals(STATE_ACTIVE)) {
            throw BusinessRuleException.buildUserException(DetailMessageEnum.TCH_033.getContent());
        }
    }
}