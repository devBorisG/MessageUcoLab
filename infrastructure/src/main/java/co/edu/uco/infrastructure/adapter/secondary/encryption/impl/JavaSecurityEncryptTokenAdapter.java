package co.edu.uco.infrastructure.adapter.secondary.encryption.impl;

import co.edu.uco.core.application.dto.encrypt.KeyPairDTO;
import co.edu.uco.core.domain.port.out.secret.EncryptTokenPort;
import org.springframework.stereotype.Service;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.util.Base64;

@Service
public class JavaSecurityEncryptTokenAdapter implements EncryptTokenPort {

    @Override
    public KeyPairDTO generateKeys() {
        try {
            KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
            generator.initialize(2048);
            KeyPair keyPair = generator.generateKeyPair();
            return new KeyPairDTO(keyPair.getPublic(), keyPair.getPrivate());
        } catch (Exception e) {
            throw new RuntimeException("Error generating keys", e);
        }
    }

    @Override
    public String generateSignature(String data, PublicKey publicKey) {
        try{
            Cipher encryptCipher = Cipher.getInstance("RSA");
            encryptCipher.init(Cipher.ENCRYPT_MODE, publicKey);

            byte[] dataBytes = data.getBytes(StandardCharsets.UTF_8);
            byte[] encryptedData = encryptCipher.doFinal(dataBytes);

            return Base64.getEncoder().encodeToString(encryptedData);
        }catch (NoSuchPaddingException | NoSuchAlgorithmException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException e){
            throw new RuntimeException("Error generating signature", e);
        }

    }

    @Override
    public Boolean access(PrivateKey privateKey, String signature, String secretName) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        byte[] signatureBytes = Base64.getDecoder().decode(signature);

        Cipher decryptCipher = Cipher.getInstance("RSA");
        decryptCipher.init(Cipher.DECRYPT_MODE, privateKey);

        byte[] decryptedData = decryptCipher.doFinal(signatureBytes);
        String data = new String(decryptedData, StandardCharsets.UTF_8);

        return data.equals(secretName);
    }
}