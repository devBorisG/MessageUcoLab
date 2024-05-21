package co.edu.uco.core.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class MessageStatusEntity {
    private UUID id;
    private String name;
}
