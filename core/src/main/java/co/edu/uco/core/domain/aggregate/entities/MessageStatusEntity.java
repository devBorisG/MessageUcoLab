package co.edu.uco.core.domain.aggregate.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class MessageStatusEntity {
    private UUID id;
    private String name;
}
