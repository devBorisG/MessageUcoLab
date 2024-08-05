package co.edu.uco.core.domain.valueobject;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public final class FunctionalityVO {

    private final UUID id;
    private final String name;
    private final LocalDateTime startDate;
    private final LocalDateTime endDate;

    public FunctionalityVO(UUID id, String name, LocalDateTime startDate, LocalDateTime endDate) {
        this.id = Objects.requireNonNull(id, "El id no puede ser nulo");
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.startDate = Objects.requireNonNull(startDate, "La fecha de inicio no puede ser nula");
        this.endDate = Objects.requireNonNull(endDate, "La fecha de fin no puede ser nula");
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FunctionalityVO that = (FunctionalityVO) o;
        return id.equals(that.id) && name.equals(that.name) &&
                startDate.equals(that.startDate) && endDate.equals(that.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, startDate, endDate);
    }

    @Override
    public String toString() {
        return "FunctionalityVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
