package co.edu.uco.core.domain.aggregate.entities;

import co.edu.uco.core.domain.aggregate.Entity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class FunctionalityEntity extends Entity<UUID> {
    private UUID id;
    private String name;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
