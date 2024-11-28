package co.edu.uco.core.domain.port.out.repository;

import lombok.Data;

import static co.edu.uco.core.CrosswordsConstant.REQUEST_COLUMN_SORT_DEFAULT;
import static co.edu.uco.utils.helper.EnumConstants.SIMPLE_PAGE_QUERY;
import static co.edu.uco.utils.helper.EnumConstants.SIMPLE_PAGE_SORT;

@Data
public final class SimplePageRequest {
    private int page = 0;
    private String sort = SIMPLE_PAGE_SORT.getValue();
    private String columnSort = REQUEST_COLUMN_SORT_DEFAULT;
    private String query = SIMPLE_PAGE_QUERY.getValue();
    private int size = 50;
}