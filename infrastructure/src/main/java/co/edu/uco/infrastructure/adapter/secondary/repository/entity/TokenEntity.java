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
public final class TokenEntity {
    @Id
    private String id;
    @Column(nullable = false, name = "creation_date")
    private LocalDateTime creationDate;
    @Column(nullable = false, name = "secret_name")
    private String secretName;
    @Column(name = "expiration_date")
    private LocalDateTime expirationDate;
    @Column(nullable = false,name = "environment_id")
    private UUID environmentId;
    @Column(name = "state_id")
    private UUID tokenStateDataId = UUID.fromString("123e4567-e89b-12d3-a456-426614174023");
}
