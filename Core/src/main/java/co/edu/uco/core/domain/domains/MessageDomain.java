package co.edu.uco.core.domain.domains;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MessageDomain {
    private UUID id;
    private String code;
    private String title;
    private String content;
    private MessageTypeDomain type;
    private MessageCategoryDomain category;
    private MessageStatusDomain status;
    private String application;
    private FunctionalityDomain functionality;
}
