package co.edu.uco.infrastructure.adapter.secondary.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "token_data")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TokenEntity {
    @Id
    private String id;

    @Column(nullable = false, name = "creation_date")
    private LocalDateTime creationDate;

    @Column(nullable = false, name = "secret_name")
    private String secretName;

    @Column(name = "expiration_date")
    private LocalDateTime expirationDate;

    @Column(nullable = false, name = "environment_id")
    private UUID environmentId;

    @Column(name = "token_state_data_id")
    private UUID tokenStateDataId = UUID.fromString("1b0f2304-68e3-4e64-ae87-fdb322d4ed3b");
}
