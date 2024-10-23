package co.edu.uco.core.domain.data;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class MessageData {
    private UUID id;
    private String code;
    private String title;
    private String content;
    private String type;
    private String category;
    private String status;
    private String application;
    private String functionality;
}