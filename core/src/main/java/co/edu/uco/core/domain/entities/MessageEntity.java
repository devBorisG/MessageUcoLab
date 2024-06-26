package co.edu.uco.core.domain.entities;

import co.edu.uco.core.domain.entities.valueobject.ContentVO;
import co.edu.uco.core.domain.entities.valueobject.TitleVO;
import co.edu.uco.utils.helper.UtilText;
import lombok.Getter;

import java.util.UUID;

@Getter
public class MessageEntity extends Entity<UUID> {
    private String code;
    private TitleVO title;
    private ContentVO content;
    private MessageTypeEntity type;
    private MessageCategoryEntity category;
    private MessageStatusEntity status;
    private String application;
    private FunctionalityEntity functionality;

    public void setCode(String code) {
        this.code = UtilText.getUtilText().trim(code);
    }

    public void setTitle(String title) {
        this.title = new TitleVO(title);
    }

    public void setContent(String content) {
        this.content = new ContentVO(content);
    }

    public void setType(MessageTypeEntity type) {
        this.type = type;
    }

    public void setCategory(MessageCategoryEntity category) {
        this.category = category;
    }

    public void setStatus(MessageStatusEntity status) {
        this.status = status;
    }

    public void setApplication(String application) {
        this.application = UtilText.getUtilText().trim(application);
    }

    public void setFunctionality(FunctionalityEntity functionality) {
        this.functionality = functionality;
    }
}
