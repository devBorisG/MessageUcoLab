package co.edu.uco.core.domain.data;

import co.edu.uco.utils.helper.UtilObject;
import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

import static co.edu.uco.utils.helper.UtilText.EMPTY;
import static co.edu.uco.utils.helper.UtilText.trim;
import static co.edu.uco.utils.helper.UtilUUID.getDefaultUUID;
import static co.edu.uco.utils.helper.UtilObject.getDefaultIsNullObject;
import static co.edu.uco.utils.helper.UtilUUID.getNewUUID;

@Getter
@ToString
public final class MessageData {
    private UUID id;
    private String code;
    private String title;
    private String content;
    private MessageTypeData type;
    private MessageCategoryData category;
    private MessageStateData status;
    private String application;
    private FunctionalityData functionality;
    public MessageData() {
        setId(getNewUUID());
        setCode(EMPTY);
        setTitle(EMPTY);
        setContent(EMPTY);
        setApplication(EMPTY);
        setType(MessageTypeData.build());
        setCategory(MessageCategoryData.build());
        setStatus(MessageStateData.build());
        setFunctionality(FunctionalityData.build());
    }
    public MessageData(UUID id, String code, String title, String content, MessageTypeData type,
                       MessageCategoryData category,  String application, FunctionalityData functionality) {
        setId(id);
        setCode(code);
        setTitle(title);
        setContent(content);
        setType(type);
        setStatus(MessageStateData.build());
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
    public void setType(MessageTypeData type) {this.type = getDefaultIsNullObject(type,MessageTypeData.build());}
    public void setCategory(MessageCategoryData category) {this.category = getDefaultIsNullObject(category, MessageCategoryData.build());}
    public void setStatus(MessageStateData status) {this.status = getDefaultIsNullObject(status, MessageStateData.build());}
    public void setApplication(String application) {
        this.application = trim(application);
    }
    public void setFunctionality(FunctionalityData functionality) {this.functionality = UtilObject.getDefaultIsNullObject(functionality, FunctionalityData.build());}
    public static MessageData build() {
        return new MessageData();
    }
}