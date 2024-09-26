package co.edu.uco.core.domain.document;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Setter
@Getter
@Document(collection = "airbyte_raw_message")
public class MessageDocument {
    @Id
    @Field("_airbyte_data.id")
    private String id;
    @Field("_airbyte_data.code")
    private String code;
    @Field("_airbyte_data.title")
    private String title;
    @Field("_airbyte_data.content")
    private String content;
    @Field("_airbyte_data.type")
    private String type;
    @Field("_airbyte_data.category")
    private String category;
    @Field("_airbyte_data.status")
    private String status;
    @Field("_airbyte_data.application")
    private String application;
    @Field("_airbyte_data.functionality")
    private String functionality;
}