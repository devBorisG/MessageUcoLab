package co.edu.uco.infrastructure.adapter.secondary.repository.mongo.model;

import co.edu.uco.utils.helper.UtilObject;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Field;

import static co.edu.uco.utils.helper.UtilText.trim;

@Getter
public final class MessageJsonDocument {
    @Field("ID")
    private String id;
    @Field("CODE")
    private String code;
    @Field("TITLE")
    private String title;
    @Field("CONTENT")
    private String content;
    @Field("TYPE_ID")
    private MessageTypeDocument type;
    @Field("CATEGORY_ID")
    private MessageCategoryDocument category;
    @Field("STATUS")
    private StatusMessageDocument status;
    @Field("APPLICATION")
    private String application;
    @Field("FUNCTIONALITY_ID")
    private String functionality;
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
    public void setStatus(StatusMessageDocument status) {
        this.status = UtilObject.getDefaultIsNullObject(status, StatusMessageDocument.build());
    }
    public void setApplication(String application) {
        this.application = trim(application);
    }
    public void setFunctionality(String functionality) {
        this.functionality = trim(functionality);
    }
    public static MessageJsonDocument build() {return new MessageJsonDocument();}
}