package co.edu.uco.infrastructure.adapter.secondary.external.secrets.impl;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SecretResponse(String name, SecretDetail value) {
        @JsonIgnoreProperties(ignoreUnknown = true)
        public record SecretDetail(String raw) { }
}