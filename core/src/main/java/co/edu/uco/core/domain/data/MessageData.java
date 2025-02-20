package co.edu.uco.core.domain.data;

import co.edu.uco.utils.helper.UtilObject;
import co.edu.uco.utils.helper.UtilText;
import co.edu.uco.utils.helper.UtilUUID;
import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

import static co.edu.uco.utils.helper.UtilText.trim;
import static co.edu.uco.utils.helper.UtilUUID.getDefaultUUID;
import static co.edu.uco.utils.helper.UtilObject.getDefaultIsNullObject;

@Getter
@ToString
public final class MessageData {
    private UUID id;
    private String code;
    private String title;
    private String content;
    private MessageTypeData type;
    private MessageCategoryData category;
    private String status;
    private String application;
    private FunctionalityData functionality;

    public MessageData() {
        setId(UtilUUID.getNewUUID());
        setCode(UtilText.EMPTY);
        setTitle(UtilText.EMPTY);
        setContent(UtilText.EMPTY);
        setApplication(UtilText.EMPTY);
        setType(MessageTypeData.build());
        setCategory(MessageCategoryData.build());
        setStatus(UtilText.EMPTY);
        setFunctionality(FunctionalityData.build());
    }
    public MessageData(UUID id, String code, String title, String content, MessageTypeData type,
                       MessageCategoryData category, String status, String application, FunctionalityData functionality) {
        setId(id);
        setCode(code);
        setTitle(title);
        setContent(content);
        setType(type);
        setApplication(application);
        setCategory(category);
        setFunctionality(functionality);
    }
    public void setId(UUID id) {
        this.id = getDefaultUUID(id);
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
    public void setType(MessageTypeData type) {this.type = UtilObject.getDefaultIsNullObject(type,MessageTypeData.build());}
    public void setCategory(MessageCategoryData category) {
        this.category = getDefaultIsNullObject(category, MessageCategoryData.build());
    }
    public void setStatus(String status) {
        this.status = trim(status);
    }
    public void setApplication(String application) {
        this.application = trim(application);
    }
    public void setFunctionality(FunctionalityData functionality) {
        this.functionality = UtilObject.getDefaultIsNullObject(functionality, FunctionalityData.build());
    }
    public static MessageData build() {
        return new MessageData();
    }
}