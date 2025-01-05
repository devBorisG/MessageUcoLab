package co.edu.uco.core.domain.domains;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public final class MessageCodeDomain {
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