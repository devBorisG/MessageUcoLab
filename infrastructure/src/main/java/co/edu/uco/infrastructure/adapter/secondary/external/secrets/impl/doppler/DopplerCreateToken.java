package co.edu.uco.infrastructure.adapter.secondary.external.secrets.impl.doppler;

import co.edu.uco.core.domain.port.out.secret.CreateTokenSecretPort;
import co.edu.uco.utils.exception.CrossWordsException;
import co.edu.uco.utils.exception.enumeration.ExceptionLocation;
import co.edu.uco.utils.exception.enumeration.ExceptionType;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import static co.edu.uco.infrastructure.configuration.InfrastructureConstant.*;

@Slf4j
@Component
public class DopplerCreateToken implements CreateTokenSecretPort {

    @Value("${doppler.token}")
    private String token;

    @Override
    public void execute(String secretName, String privateKey) {
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse(JSON_SERIALIZER_CONTENT_TYPE);
        RequestBody body = RequestBody.create(String.format(BODY_DOPPLER_CREATE_TOKEN_REQUEST, secretName, secretName, privateKey), mediaType);
        Request request = new Request.Builder()
                .url(URL_DOPPLER_CONFIG_SECRETS_POST)
                .post(body)
                .addHeader(REQUEST_GET_HEADER_ACCEPT.toLowerCase(), JSON_SERIALIZER_CONTENT_TYPE)
                .addHeader(REQUEST_GET_HEADER_CONTENT_TYPE.toLowerCase(), JSON_SERIALIZER_CONTENT_TYPE)
                .addHeader(REQUEST_GET_HEADER_AUTHORIZATION.toLowerCase(), BEARER_TOKEN.formatted(token))
                .build();

        //TODO: Eliminar codigo hardcodeado
        try(Response response = client.newCall(request).execute()) {
            if(!response.isSuccessful()) {
                log.error("Error code from response {} : ", response.code());
                throw CrossWordsException.build(
                        "Error code from response %s : ".formatted(response.code()),
                        "An error occurred while creating the token, please try again later",
                        null,
                        ExceptionType.TECHNICAL,
                        ExceptionLocation.INFRASTRUCTURE
                );
            }
        } catch (Exception e) {
            log.error("Error occurred sending request to Doppler", e);
            throw CrossWordsException.build(
                    "Error occurred sending request to Doppler",
                    "An error occurred while creating the token, please try again later",
                    e,
                    ExceptionType.TECHNICAL,
                    ExceptionLocation.INFRASTRUCTURE
            );
        }
    }
}
