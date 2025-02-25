package co.edu.uco.infrastructure.adapter.secondary.external.secrets.impl.doppler;

import co.edu.uco.core.domain.port.out.secret.CreateTokenSecretPort;
import co.edu.uco.utils.exception.CrossWordsException;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DopplerCreateToken implements CreateTokenSecretPort {

    @Value("${doppler.token}")
    private String token;

    @Override
    public String execute(String tokenID, String tokenEncrypted) {
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\"project\":\"ucolab\",\"config\":\"dev\",\"change_requests\":[{\"name\":\"_%s\",\"originalName\":\"_%s\",\"value\":\"%s\"}]}".formatted(tokenEncrypted, tokenEncrypted, tokenID));
        Request request = new Request.Builder()
                .url("https://api.doppler.com/v3/configs/config/secrets")
                .post(body)
                .addHeader("accept", "application/json")
                .addHeader("content-type", "application/json")
                .addHeader("authorization", "Bearer %s".formatted(token))
                .build();

        try(Response response = client.newCall(request).execute()) {
            if(!response.isSuccessful()) {
                throw new RuntimeException("Unespected code " + response);
            }
            if(response.body() == null) {
                throw new RuntimeException("Response body is null");
            }
            return response.body().string();
        } catch (CrossWordsException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Error al crear el token", e);
        }
    }
}
