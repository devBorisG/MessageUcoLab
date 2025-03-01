package co.edu.uco.infrastructure.adapter.secondary.external.secrets.impl.doppler;

import co.edu.uco.core.domain.port.out.secret.FindSecretTokenPort;
import co.edu.uco.utils.exception.CrossWordsException;
import co.edu.uco.utils.exception.enumeration.ExceptionLocation;
import co.edu.uco.utils.exception.enumeration.ExceptionType;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;

import static co.edu.uco.infrastructure.configuration.InfrastructureConstant.*;

@Slf4j
@Component
public class DopplerFindToken implements FindSecretTokenPort {
    @Value("${doppler.token}")
    private String token;

    private final ObjectMapper mapper;

    public DopplerFindToken(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    //TODO: Eliminar codigo hardcodeado
    @Override
    public Map<String, String> findSecretToken(String secretName) {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(URL_DOPPLER_CONFIG_SECRETS_GET.formatted(secretName))
                .get()
                .addHeader(REQUEST_GET_HEADER_ACCEPT.toLowerCase(), JSON_SERIALIZER_CONTENT_TYPE)
                .addHeader(REQUEST_GET_HEADER_AUTHORIZATION.toLowerCase(), BEARER_TOKEN.formatted(token))
                .build();

        try(Response response = client.newCall(request).execute()){
            if(!response.isSuccessful()){
                log.error("Error code from response {} : ", response.code());
                throw CrossWordsException.build(
                        "Error code from response %s : ".formatted(response.code()),
                        "An error occurred while verify the token, please try again later",
                        null,
                        ExceptionType.TECHNICAL,
                        ExceptionLocation.INFRASTRUCTURE
                );
            }else {
                DopplerFindTokenDTO dopplerFindTokenDTO = mapper.readValue(response.body().byteStream(), DopplerFindTokenDTO.class);
                return Map.of(
                        "secretName", dopplerFindTokenDTO.getName(),
                        "privateKey", dopplerFindTokenDTO.getRaw()
                );
            }
        }catch (Exception e){
            log.error("Error occurred sending request to Doppler", e);
            throw CrossWordsException.build(
                    "Error occurred sending request to Doppler",
                    "An error occurred while verify the token, please try again later",
                    e,
                    ExceptionType.TECHNICAL,
                    ExceptionLocation.INFRASTRUCTURE
            );
        }
    }
}
