package co.edu.uco.infrastructure.adapter.secondary.external.secrets.impl;

import co.edu.uco.infrastructure.adapter.secondary.external.secrets.Secrets;
import co.edu.uco.utils.exception.CrossWordsException;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DopplerSecrets implements Secrets {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Value("${doppler.token}")
    private String token;

    @Override
    public String getSecret(String secretName) {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.doppler.com/v3/configs/config/secret?project=ucolab&config=dev&name=%s".formatted(secretName))
                .get()
                .addHeader("accept", "application/json")
                .addHeader("authorization", "Bearer %s".formatted(token))
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new CrossWordsException("Unexpected code " + response, "", null);
            }
            if (response.body() == null) {
                throw new CrossWordsException("Response body is null", "", null);
            }
            String responseBody = response.body().string();
            SecretResponse secretResponse = objectMapper.readValue(responseBody, SecretResponse.class);
            return secretResponse.value() != null ? secretResponse.value().raw() : null;
        } catch (CrossWordsException e) {
            throw e;
        } catch (Exception e) {
            throw new CrossWordsException("Error getting secret", "", e);
        }
    }
}