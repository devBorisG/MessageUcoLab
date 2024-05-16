package co.edu.uco.core.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class MessageDTO {
    private String name;
    private String description;
}
