package co.edu.uco.core.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import static co.edu.uco.core.CrosswordsConstant.*;

@Setter
@Getter
@Document(collection = COLLECTION_MONGO_ADAPTER)
public final class MessageDocument {
    @Id
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
}