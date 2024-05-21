package co.edu.uco.core.domain.domains;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class MessageDomain {
    private UUID id;
    private String code;
    private String title;
    private String content;
}
