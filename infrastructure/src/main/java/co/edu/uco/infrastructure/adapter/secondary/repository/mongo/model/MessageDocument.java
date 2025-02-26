package co.edu.uco.infrastructure.adapter.secondary.repository.mongo.model;

import co.edu.uco.utils.helper.UtilObject;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import static co.edu.uco.utils.helper.UtilText.trim;

@Getter
@Document(collection = "message")
public final class MessageDocument {
    @Id
    private String id;
    private String code;
    private String title;
    private String content;
    @DBRef
    private MessageTypeDocument type;
    @DBRef
    private MessageCategoryDocument category;
    @DBRef
    private MessageStateDocument status;
    @DBRef
    private ApplicationDocument application;
    @DBRef
    private FunctionalityDocument functionality;
    public void setId(String id) {
        this.id = trim(id);
    }
    public void setCode(String code) {
        this.code = trim(code);
    }
    public void setTitle(String title) {
        this.title = trim(title);
    }
    public void setContent(String content) {
        this.content = trim(content);
    }
    public void setType(MessageTypeDocument type) {
        this.type = UtilObject.getDefaultIsNullObject(MessageTypeDocument.build(), type);
    }
    public void setCategory(MessageCategoryDocument category) {
        this.category = UtilObject.getDefaultIsNullObject(MessageCategoryDocument.build(), category);
    }
    public void setStatus(MessageStateDocument status) {
        this.status = UtilObject.getDefaultIsNullObject(status, MessageStateDocument.build());
    }
    public void setApplication(ApplicationDocument application) {
        this.application = UtilObject.getDefaultIsNullObject(application, ApplicationDocument.build());
    }
    public void setFunctionality(FunctionalityDocument functionality) {
        this.functionality = UtilObject.getDefaultIsNullObject(functionality, FunctionalityDocument.build());
    }
}