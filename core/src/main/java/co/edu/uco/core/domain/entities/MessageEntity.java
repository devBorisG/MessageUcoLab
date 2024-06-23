package co.edu.uco.core.domain.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class MessageEntity {
    private UUID id;
    private String code;
    private String title;
    private String content;
    private MessageTypeEntity type;
    private MessageCategoryEntity category;
    private MessageStatusEntity status;
    private String application;
    private FunctionalityEntity functionality;
}
