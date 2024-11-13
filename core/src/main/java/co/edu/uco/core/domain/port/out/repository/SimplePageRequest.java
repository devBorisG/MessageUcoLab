package co.edu.uco.core.domain.port.out.repository;

import lombok.Data;

import static co.edu.uco.utils.helper.UtilText.EMPTY;

@Data
public final class SimplePageRequest {
    private int page = 0;
    private String sort = "ASC";
    private String columnSort = EMPTY;
    private String query = "%";
    private int size = 50;
}