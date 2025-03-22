package co.edu.uco.infrastructure.adapter.secondary.repository.mongo.model;

import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Field;

import static co.edu.uco.utils.helper.UtilText.trim;

@Getter
public final class FunctionalityDocument {
    @Field("ID")
    private String id;
    @Field("NAME")
    private String name;
    public void setId(String id) {
        this.id = trim(id);
    }
    public void setName(String name) {
        this.name = trim(name);
    }
    public static FunctionalityDocument build() {
        return new FunctionalityDocument();
    }
}