package co.edu.uco.infrastructure.adapter.secondary.external.secrets;

import java.io.IOException;

public interface Secrets {
    String getSecret(String secretName) throws IOException;
}
