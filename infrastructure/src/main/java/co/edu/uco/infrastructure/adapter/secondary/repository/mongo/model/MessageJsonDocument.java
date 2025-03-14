package co.edu.uco.infrastructure.adapter.secondary.repository.mongo.model;

import co.edu.uco.utils.helper.UtilObject;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import static co.edu.uco.utils.helper.UtilText.trim;

@Getter
public final class MessageJsonDocument {
    @Id
    @JsonProperty("ID")
    private String id;
    @JsonProperty("CODE")
    private String code;
    @JsonProperty("TITLE")
    private String title;
    @JsonProperty("CONTENT")
    private String content;
    @JsonProperty("TYPE_ID")
    private MessageTypeDocument type;
    @JsonProperty("CATEGORY_ID")
    private MessageCategoryDocument category;
    @Field(name = "STATUS")
    private StatusMessageDocument status;
    @Field(name = "APPLICATION")
    private String application;
    @Field(name = "FUNCTIONALITY_ID")
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