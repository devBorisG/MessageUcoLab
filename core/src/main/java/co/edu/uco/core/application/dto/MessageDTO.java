package co.edu.uco.core.application.dto;

import lombok.Getter;

import java.util.UUID;

import static co.edu.uco.utils.helper.UtilText.getUtilText;
import static co.edu.uco.utils.helper.UtilUUID.getUtilUUID;

@Getter
public class MessageDTO {

    private UUID id;
    private String code;
    private String title;
    private String content;
    private String application;

    public MessageDTO(UUID id, String code, String title, String content, String application) {
        setId(id);
        setCode(code);
        setTitle(title);
        setContent(content);
        setApplication(application);
    }

    public void setId(UUID id) {
        this.id = getUtilUUID().getDefaultUUID(id);
    }

    public void setCode(String code) {
        this.code = getUtilText().trim(code);
    }

    public void setTitle(String title) {
        this.title = getUtilText().trim(title);
    }

    public void setContent(String content) {
        this.content = getUtilText().trim(content);
    }

    public void setApplication(String application) {
        this.application = getUtilText().trim(application);
    }

    public static MessageDTO create(UUID id, String code, String title, String content, String application) {
        return new MessageDTO(id, code, title, content, application);
    }
}
