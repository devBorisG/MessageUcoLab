package co.edu.uco.core.domain.usecase;

import co.edu.uco.core.domain.port.out.repository.token.FindTokenRepository;
import co.edu.uco.core.domain.port.out.secret.EncryptTokenPort;
import co.edu.uco.core.domain.port.out.secret.FindSecretTokenPort;
import co.edu.uco.core.domain.usecase.handling.HandlingVerifyAccessPort;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class VerifyAccessUseCase implements HandlingVerifyAccessPort {
    private final EncryptTokenPort encryptTokenPort;
    private final FindSecretTokenPort findSecretTokenPort;
    private final FindTokenRepository findTokenRepository;

    public VerifyAccessUseCase(EncryptTokenPort encryptTokenPort, FindSecretTokenPort findSecretTokenPort, FindTokenRepository findTokenRepository) {
        this.encryptTokenPort = encryptTokenPort;
        this.findSecretTokenPort = findSecretTokenPort;
        this.findTokenRepository = findTokenRepository;
    }

    @Override
    public boolean verifyAccess(String token) {
        //TODO: Se agrega esto de prueba pero hay que esperar a FEDERICO haga su parte :)
        String secretName = "UCOLAB_TOKEN_PRIVATE_KEY_00000000_0000_0000_0000_000000000001DDDDDDDD_DDDD_DDDD_DDDD_DDDDDDDDDDDD";
        findTokenRepository.findId(token);
       // findTokenRepository.findAll();
        Map<String, String> secret = findSecretTokenPort.findSecretToken(secretName);
        try{
            return encryptTokenPort.access(
                    secret.get("privateKey"),
                    token,
                    secret.get("secretName")
            );
        } catch (Exception e){
            return false;
        }
    }
}
