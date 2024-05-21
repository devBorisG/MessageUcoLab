package co.edu.uco.core.domain.domains;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class FunctionalityDomain {
    private UUID id;
    private String name;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
