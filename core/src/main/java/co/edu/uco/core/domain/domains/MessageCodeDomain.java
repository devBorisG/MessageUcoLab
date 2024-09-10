package co.edu.uco.core.domain.domains;

import co.edu.uco.core.application.dto.MessageCodeDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageCodeDomain {
    private String code;

    public MessageCodeDomain(String code) {
        setCode(code);
    }

    public MessageCodeDomain() {
    }

    public static MessageCodeDomain create(String code) {
        return new MessageCodeDomain(code);
    }
}
