package co.edu.uco.core.application.dto;


import lombok.Getter;

import static co.edu.uco.core.CrosswordsConstant.*;
import static co.edu.uco.core.CrosswordsConstant.REQUEST_SIZE_DEFAULT;
import static co.edu.uco.utils.helper.UtilText.getDefault;

@Getter
public final class PageRequestDTO {
    private String page;
    private String sort;
    private String columnSort;
    private String size;
    public PageRequestDTO(String page, String sort, String columnSort, String size) {
        setPage(page);
        setSort(sort);
        setColumnSort(columnSort);
        setSize(size);
    }
    public void setPage(String page) {
        this.page = getDefault(page, String.valueOf(REQUEST_PAGE_DEFAULT));
    }
    public void setSort(String sort) {
        this.sort = getDefault(sort, REQUEST_PAGE_SORT_ASC);
    }
    public void setColumnSort(String columnSort) {
        this.columnSort = getDefault(columnSort, REQUEST_COLUMN_SORT_DEFAULT);
    }
    public void setSize(String size) {
        this.size = getDefault(size, String.valueOf(REQUEST_SIZE_DEFAULT));
    }
}