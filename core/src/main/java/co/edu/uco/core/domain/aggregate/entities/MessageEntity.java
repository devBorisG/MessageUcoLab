package co.edu.uco.core.domain.aggregate.entities;

import co.edu.uco.core.domain.aggregate.Entity;
import co.edu.uco.core.domain.aggregate.entities.valueobject.ContentVO;
import co.edu.uco.core.domain.aggregate.entities.valueobject.TitleVO;

import java.util.UUID;

import static co.edu.uco.utils.helper.UtilText.trim;

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
        this.code = trim(code);
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
        this.application = trim(application);
    }

    public void setFunctionality(FunctionalityEntity functionality) {
        this.functionality = functionality;
    }

    public String getCode() {
        return code;
    }

    public TitleVO getTitle() {
        return title;
    }

    public ContentVO getContent() {
        return content;
    }

    public MessageTypeEntity getType() {
        return type;
    }

    public MessageCategoryEntity getCategory() {
        return category;
    }

    public MessageStatusEntity getStatus() {
        return status;
    }

    public String getApplication() {
        return application;
    }

    public FunctionalityEntity getFunctionality() {
        return functionality;
    }
}
