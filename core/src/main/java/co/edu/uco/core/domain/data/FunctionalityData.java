package co.edu.uco.core.domain.data;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

import static co.edu.uco.utils.helper.UtilDate.TIME;
import static co.edu.uco.utils.helper.UtilDate.getDefaultTimeIfNull;
import static co.edu.uco.utils.helper.UtilObject.getDefaultIsNullObject;
import static co.edu.uco.utils.helper.UtilText.EMPTY;
import static co.edu.uco.utils.helper.UtilText.trim;
import static co.edu.uco.utils.helper.UtilUUID.getDefaultUUID;
import static co.edu.uco.utils.helper.UtilUUID.getNewUUID;

@Getter
public final class FunctionalityData {
    private UUID id;
    private String name;
    private ApplicationData application;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private FunctionalityStateData state;
    public FunctionalityData() {
        setId(getNewUUID());
        setName(EMPTY);
        setStartDate(TIME);
        setEndDate(TIME);
        setState(FunctionalityStateData.build());
    }
    public FunctionalityData(UUID id, String name, ApplicationData application, LocalDateTime startDate, LocalDateTime endDate, FunctionalityStateData state) {
        setId(id);
        setName(name);
        setApplication(application);
        setStartDate(startDate);
        setEndDate(endDate);
        setState(state);
    }
    public void setId(UUID id) {
        this.id = getDefaultUUID(id);
    }
    public void setName(String name) {
        this.name = trim(name);
    }
    public void setStartDate(LocalDateTime startDate) {
        this.startDate = getDefaultTimeIfNull(startDate);
    }
    public void setEndDate(LocalDateTime endDate) {
        this.endDate = getDefaultTimeIfNull(endDate);
    }
    public void setApplication(ApplicationData application) { this.application = getDefaultIsNullObject(application, ApplicationData.build());}
    public void setState(FunctionalityStateData state) { this.state = getDefaultIsNullObject(state, FunctionalityStateData.build());}
    public static FunctionalityData build() {
        return new FunctionalityData();
    }
}