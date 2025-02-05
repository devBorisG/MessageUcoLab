package co.edu.uco.infrastructure.adapter.secondary.repository.mongo;

import co.edu.uco.utils.helper.UtilObject;
import co.edu.uco.utils.helper.UtilText;
import lombok.Getter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import static co.edu.uco.infrastructure.configuration.InfrastructureConstant.*;
import static co.edu.uco.utils.helper.UtilObject.getDefaultIsNullObject;
import static co.edu.uco.utils.helper.UtilText.trim;

@Getter
@Document(collection = COLLECTION_MONGO_ADAPTER)
public final class MessageDocument {
    @Id
    private ObjectId mongoId;
    @Field(FIELD_MONGO_ADAPTER_ID)
    private String id;
    @Field(FIELD_MONGO_ADAPTER_CODE)
    private String code;
    @Field(FIELD_MONGO_ADAPTER_TITLE)
    private String title;
    @Field(FIELD_MONGO_ADAPTER_CONTENT)
    private String content;
    @Field(FIELD_MONGO_ADAPTER_TYPE)
    private String type;
    @Field(FIELD_MONGO_ADAPTER_CATEGORY)
    private String category;
    @Field(FIELD_MONGO_ADAPTER_STATUS)
    private String status;
    @Field(FIELD_MONGO_ADAPTER_APPLICATION)
    private String application;
    @Field(FIELD_MONGO_ADAPTER_FUNCTIONALITY)
    private String functionality;

    public void setMongoId(ObjectId mongoId) {
        this.mongoId = getDefaultIsNullObject(mongoId, new ObjectId());
    }

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

    public void setType(String type) {
        this.type = trim(type);
    }

    public void setCategory(String category) {
        this.category = trim(category);
    }

    public void setStatus(String status) {
        this.status = trim(status);
    }

    public void setApplication(String application) {
        this.application = trim(application);
    }

    public void setFunctionality(String functionality) {
        this.functionality = trim(functionality);
    }
}