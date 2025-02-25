package co.edu.uco.core.domain.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public final class TokenData {

    private String id;

    private LocalDateTime creationDate;

    private LocalDateTime expirationDate;

    private UUID environmentId;
}
