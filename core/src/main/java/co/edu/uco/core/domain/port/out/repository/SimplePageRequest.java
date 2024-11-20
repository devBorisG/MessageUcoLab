package co.edu.uco.core.domain.port.out.repository;

import lombok.Data;

import static co.edu.uco.core.CrosswordsConstant.REQUEST_COLUMN_SORT_DEFAULT;

@Data
public final class SimplePageRequest {
    private int page = 0;
    private String sort = "ASC";
    private String columnSort = REQUEST_COLUMN_SORT_DEFAULT;
    private String query = "%";
    private int size = 50;
}