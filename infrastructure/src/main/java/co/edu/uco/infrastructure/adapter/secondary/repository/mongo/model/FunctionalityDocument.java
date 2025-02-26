package co.edu.uco.infrastructure.adapter.secondary.repository.mongo.model;

import jakarta.persistence.Id;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

import static co.edu.uco.utils.helper.UtilDate.getDefaultTimeIfNull;
import static co.edu.uco.utils.helper.UtilText.trim;
import static co.edu.uco.utils.helper.UtilText.EMPTY;
import static co.edu.uco.utils.helper.UtilDate.TIME;
import static co.edu.uco.utils.helper.UtilObject.getDefaultIsNullObject;

@Getter
@Document(collection = "functionality")
public final class FunctionalityDocument {
    @Id
    private String id;
    private String name;
    @DBRef
    private ApplicationDocument application;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    @DBRef
    private FunctionalityStateDocument state;
    public FunctionalityDocument() {
        setId(EMPTY);
        setName(EMPTY);
        setStartDate(TIME);
        setEndDate(TIME);
        setApplication(ApplicationDocument.build());
        setState(FunctionalityStateDocument.build());
    }
    public FunctionalityDocument(String id, String name, ApplicationDocument application, LocalDateTime startDate, LocalDateTime endDate,
                                 FunctionalityStateDocument state) {
        setId(id);
        setName(name);
        setApplication(application);
        setStartDate(startDate);
        setEndDate(endDate);
        setState(state);
    }
    public void setId(String id) {
        this.id = trim(id);
    }
    public void setName(String name) {
        this.name = trim(name);
    }
    public void setStartDate(LocalDateTime startDate) { this.startDate = getDefaultTimeIfNull(startDate);}
    public void setEndDate(LocalDateTime endDate) { this.endDate = getDefaultTimeIfNull(endDate); }
    public void setApplication(ApplicationDocument application) {
        this.application = getDefaultIsNullObject(application, ApplicationDocument.build());
    }
    public void setState(FunctionalityStateDocument state) {
        this.state = getDefaultIsNullObject(state, FunctionalityStateDocument.build());
    }
    public static FunctionalityDocument build() {
        return new FunctionalityDocument();
    }
}