package co.edu.uco.infrastructure.adapter.secondary.repository.mongo.model;

import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Field;

import static co.edu.uco.utils.helper.UtilObject.getDefaultIsNullObject;
import static co.edu.uco.utils.helper.UtilText.trim;

@Getter
public final class MessageDocument {
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
    public void setType(MessageTypeDocument type) { this.type = getDefaultIsNullObject(MessageTypeDocument.build(), type);}
    public void setCategory(MessageCategoryDocument category) { this.category = getDefaultIsNullObject(MessageCategoryDocument.build(), category);}
    public void setStatus(StatusMessageDocument status) {  this.status = getDefaultIsNullObject(status, StatusMessageDocument.build());}
    public void setApplication(String application) {this.application = trim(application);}
    public void setFunctionality(FunctionalityDocument functionality) { this.functionality = getDefaultIsNullObject(FunctionalityDocument.build(), functionality);}
    public static MessageDocument build() {return new MessageDocument();}
}