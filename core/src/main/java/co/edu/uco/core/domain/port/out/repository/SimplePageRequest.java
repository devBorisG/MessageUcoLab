package co.edu.uco.core.domain.port.out.repository;

import co.edu.uco.utils.helper.UtilNumeric;
import lombok.Getter;

import static co.edu.uco.core.CrosswordsConstant.*;
import static co.edu.uco.utils.helper.UtilText.getDefault;

@Getter
public final class SimplePageRequest {
    private int page;
    private String sort;
    private String columnSort;
    private int size;
    public SimplePageRequest(int page, String sort, String columnSort, int sizeInt) {
        this.page = page;
        this.sort = sort;
        this.columnSort = columnSort;
        this.size = sizeInt;
    }
    public void setPage(int page) {
        this.page = UtilNumeric.getDefault(page, (int) REQUEST_PAGE_DEFAULT);
    }
    public void setSort(String sort) {
        this.sort = getDefault(sort, REQUEST_PAGE_SORT_ASC);
    }
    public void setColumnSort(String columnSort) {
        this.columnSort = getDefault(columnSort, REQUEST_COLUMN_SORT_DEFAULT);
    }
    public void setSize(int size) {
        this.size = UtilNumeric.getDefault(size, (int) REQUEST_SIZE_DEFAULT);
    }
}