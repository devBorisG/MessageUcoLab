package co.edu.uco.infrastructure.adapter.secondary.external.secrets.impl.doppler;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;

@AllArgsConstructor
@Getter
public class DopplerFindTokenDTO {
    private final String name;
    private final String raw;

    @JsonCreator
    public DopplerFindTokenDTO(
            @JsonProperty("name") String name,
            @JsonProperty("value") Map<String, Object> value) {
        this.name = name;
        this.raw = value != null ? (String) value.get("raw") : null;
    }
}
