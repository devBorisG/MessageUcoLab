package co.edu.uco.core.domain.domains;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public final class MessageStatusDomain {
    private UUID id;
    private String name;
}