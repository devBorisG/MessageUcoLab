package co.edu.uco.core.domain.port.out.secret;

public interface CreateTokenSecretPort {
    String execute(String tokenId, String tokenEncrypted);
}
