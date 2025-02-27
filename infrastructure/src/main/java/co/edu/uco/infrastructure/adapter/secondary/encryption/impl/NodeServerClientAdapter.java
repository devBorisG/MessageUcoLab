package co.edu.uco.infrastructure.adapter.secondary.encryption.impl;

import co.edu.uco.core.application.dto.encrypt.AccessRequestDTO;
import co.edu.uco.core.application.dto.encrypt.AccessResponseDTO;
import co.edu.uco.core.application.dto.encrypt.KeyPairResponseDTO;
import co.edu.uco.core.domain.port.out.secret.EncryptService;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class NodeServerClientAdapter implements EncryptService {

    private final OkHttpClient client;
    private final ObjectMapper objectMapper;
    private final String baseUrl;

    public NodeServerClientAdapter() {
        this.client = new OkHttpClient();
        this.objectMapper = new ObjectMapper();
        // Asegúrate de que la URL base sea la correcta para tus endpoints
        this.baseUrl = "http://localhost:8082/api";
    }

    @Override
    public KeyPairResponseDTO generateKeys() {
        // Se usa POST, aunque no se envía body, se crea uno vacío
        RequestBody emptyBody = RequestBody.create("", MediaType.get("application/json; charset=utf-8"));
        Request request = new Request.Builder()
                .url(baseUrl + "/generate-keys")
                .post(emptyBody)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                String responseBody = response.body().string();
                return objectMapper.readValue(responseBody, KeyPairResponseDTO.class);
            } else {
                throw new RuntimeException("Error generando llaves: " + response.code() + " - " + response.message());
            }
        } catch (IOException e) {
            throw new RuntimeException("Error en la comunicación con el servidor", e);
        }
    }

    @Override
    public AccessResponseDTO access(AccessRequestDTO accessRequest) {
        try {
            String json = objectMapper.writeValueAsString(accessRequest);
            RequestBody body = RequestBody.create(json, MediaType.get("application/json; charset=utf-8"));
            Request request = new Request.Builder()
                    .url(baseUrl + "/access")
                    .post(body)
                    .build();

            try (Response response = client.newCall(request).execute()) {
                if (response.isSuccessful()) {
                    String responseBody = response.body().string();
                    return objectMapper.readValue(responseBody, AccessResponseDTO.class);
                } else {
                    throw new RuntimeException("Error en la verificación: " + response.code() + " - " + response.message());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Error en la comunicación con el servidor", e);
        }
    }
}