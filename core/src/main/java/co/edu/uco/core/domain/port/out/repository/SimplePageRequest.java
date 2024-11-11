package co.edu.uco.core.domain.port.out.repository;

import lombok.Data;

@Data
public final class SimplePageRequest {
    private int page = 0;
    private String sort = "ASC";
    private String columnSort = ""; // column name
    private String query = "%";
    private int size = 50;
}