package co.edu.uco.core.domain.port.out.repository;

import lombok.Data;

import static co.edu.uco.core.CrosswordsConstant.REQUEST_COLUMN_SORT_DEFAULT;
import static co.edu.uco.core.CrosswordsConstant.REQUEST_PAGE_SORT_ASC;
import static co.edu.uco.core.CrosswordsConstant.REQUEST_SIZE_DEFAULT;

@Data
public final class SimplePageRequest {
    private int page = 0;
    private String sort = REQUEST_PAGE_SORT_ASC;
    private String columnSort = REQUEST_COLUMN_SORT_DEFAULT;
    private int size = REQUEST_SIZE_DEFAULT;
}