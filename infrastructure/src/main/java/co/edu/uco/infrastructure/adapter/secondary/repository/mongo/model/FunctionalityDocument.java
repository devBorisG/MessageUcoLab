package co.edu.uco.infrastructure.adapter.secondary.repository.mongo.model;

import jakarta.persistence.Id;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;

import static co.edu.uco.utils.helper.UtilText.trim;

@Getter
@Document(collection = "functionality")
public final class FunctionalityDocument {
    @Id
    private String id;
    private String name;
//    private LocalDateTime startDate;
//    private LocalDateTime endDate;
    public void setId(String id) {
        this.id = trim(id);
    }
    public void setName(String name) {
        this.name = trim(name);
    }
//    public void setStartDate(LocalDateTime startDate) {
//        this.startDate = getDefaultTimeIfNull(startDate);
//    }
//    public void setEndDate(LocalDateTime endDate) {
//        this.endDate = getDefaultTimeIfNull(endDate);
//    }
    public static FunctionalityDocument build() {
        return new FunctionalityDocument();
    }
}