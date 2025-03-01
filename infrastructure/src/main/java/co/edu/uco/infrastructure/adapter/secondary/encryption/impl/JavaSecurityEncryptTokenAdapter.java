package co.edu.uco.infrastructure.adapter.secondary.encryption.impl;

import co.edu.uco.core.application.dto.encrypt.KeyPairDTO;
import co.edu.uco.core.domain.port.out.secret.EncryptTokenPort;
import co.edu.uco.utils.exception.CrossWordsException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

import static co.edu.uco.infrastructure.configuration.InfrastructureConstant.*;

@Slf4j
@Service
public class JavaSecurityEncryptTokenAdapter implements EncryptTokenPort {

    @Override
    public KeyPairDTO generateKeys() {
        try {
            KeyPairGenerator generator = KeyPairGenerator.getInstance(ALGORITHM_GENERATE_PAIR_KEY);
            generator.initialize(PAIR_KEY_SIZE);
            KeyPair keyPair = generator.generateKeyPair();
            return new KeyPairDTO(keyPair.getPublic(), keyPair.getPrivate());
        } catch (Exception e) {
            log.error("Error generating keys", e);
            throw CrossWordsException.build("Error generating keys", e);
        }
    }

    @Override
    public String generateSignature(String data, PublicKey publicKey) {
        try{
            Cipher encryptCipher = Cipher.getInstance(ALGORITHM_PAIR_KEY);
            encryptCipher.init(Cipher.ENCRYPT_MODE, publicKey);

            byte[] dataBytes = data.getBytes(StandardCharsets.UTF_8);
            byte[] encryptedData = encryptCipher.doFinal(dataBytes);

            return Base64.getEncoder().encodeToString(encryptedData);
        }catch (NoSuchPaddingException | NoSuchAlgorithmException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException e){
            log.error("Error generating signature", e);
            throw CrossWordsException.build("Error generating signature", e);
        }
    }

    @Override
    public Boolean access(String privateKey, String signature, String secretName) {
        byte[] signatureBytes = Base64.getDecoder().decode(signature);
        byte[] privateKeyBytes = Base64.getDecoder().decode(privateKey);

        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(privateKeyBytes);
        try{
            Cipher decryptCipher = Cipher.getInstance(ALGORITHM_PAIR_KEY);
            KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM_GENERATE_PAIR_KEY);
            decryptCipher.init(Cipher.DECRYPT_MODE, keyFactory.generatePrivate(keySpec));

            byte[] decryptedData = decryptCipher.doFinal(signatureBytes);
            String data = new String(decryptedData, StandardCharsets.UTF_8);

            return data.equals(secretName);
        }catch (NoSuchPaddingException | NoSuchAlgorithmException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException | InvalidKeySpecException e){
            log.error("Error verifying access", e);
            return false;
        }
    }
}