package co.edu.uco.core.domain.domains;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class FunctionalityDomain {
    private UUID id;
    private String name;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
