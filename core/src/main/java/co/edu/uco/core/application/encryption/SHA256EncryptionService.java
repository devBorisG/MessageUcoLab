package co.edu.uco.core.application.encryption;

import co.edu.uco.core.application.catalog.strategy.inmemory.enums.DetailMessageEnum;
import co.edu.uco.core.domain.port.out.secret.EncryptionService;
import co.edu.uco.utils.exception.CrossWordsException;
import org.springframework.stereotype.Component;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;

import static co.edu.uco.core.CrosswordsConstant.SHA_256;

@Component
public final class SHA256EncryptionService implements EncryptionService {
    @Override
    public String encrypt(String data) {
        try {
            var digest = MessageDigest.getInstance(SHA_256);
            byte[] hash = digest.digest(data.getBytes());
            return HexFormat.of().formatHex(hash).toUpperCase();
        } catch (NoSuchAlgorithmException e) {
            throw CrossWordsException.build(DetailMessageEnum.TCH_034.getContent(), e);
        }
    }
}