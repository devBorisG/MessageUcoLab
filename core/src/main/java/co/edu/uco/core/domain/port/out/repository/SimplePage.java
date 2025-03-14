package co.edu.uco.core.domain.port.out.repository;

import co.edu.uco.core.domain.data.MessageData;
import lombok.Getter;
import org.springframework.data.domain.Page;

import java.util.List;

import static co.edu.uco.utils.helper.UtilNumeric.getDefault;
import static co.edu.uco.utils.helper.UtilObject.getDefaultIsNullObject;

@Getter
public final class SimplePage<T> {
    private List<T> data;
    private int currentPage;
    private int pageSize;
    private long totalItems;
    private int totalPages;
    public SimplePage(List<T> data, int currentPage, int pageSize, long totalItems, int totalPages) {
        this.data = data;
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalItems = totalItems;
        this.totalPages = totalPages;
    }
    public static <T> SimplePage<T> of(Page<T> map) {
        return new SimplePage<>(map.getContent(), map.getNumber(), map.getSize(), map.getTotalElements(), map.getTotalPages());
    }
    public static <T> SimplePage<T> of(List<T> data, int currentPage, int pageSize, long totalItems, int totalPage) {
        return new SimplePage<>(data, currentPage, pageSize, totalItems, totalPage);
    }

    public void setData(List<T> data) {
        this.data = getDefaultIsNullObject(data, List.of());
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = (int) getDefault(currentPage);
    }

    public void setPageSize(int pageSize) {
        this.pageSize = (int) getDefault(pageSize);
    }

    public void setTotalItems(long totalItems) {
        this.totalItems = (long) getDefault(totalItems);
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = (int) getDefault(totalPages);
    }
}