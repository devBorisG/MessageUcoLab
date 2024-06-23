package co.edu.uco.core.domain.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class MessageCategoryEntity {
    private UUID id;
    private String name;
}
