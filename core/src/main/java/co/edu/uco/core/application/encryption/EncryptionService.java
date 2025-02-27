package co.edu.uco.core.application.encryption;

import co.edu.uco.utils.helper.UtilPairKey;
import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

@Service
public class EncryptionService {

    private PublicKey getPublicKeyFromString(String publicKeyPEM) {
        String publicKeyPEMFormatted = UtilPairKey.publicKeyFormatted(publicKeyPEM);

        byte[] keyBytes = Base64.getDecoder().decode(publicKeyPEMFormatted);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
        try {
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            return keyFactory.generatePublic(keySpec);
        }catch (Exception e){
            throw new RuntimeException("Error al obtener la llave publica", e);
        }
    }

    public String encryptMessage(String message, String publicKeyPEM) {
        PublicKey publicKey = getPublicKeyFromString(publicKeyPEM);

        try{
            Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            byte[] encryptedBytes = cipher.doFinal(message.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (Exception e){
            throw new RuntimeException("Error al encriptar el mensaje", e);
        }
    }
}
