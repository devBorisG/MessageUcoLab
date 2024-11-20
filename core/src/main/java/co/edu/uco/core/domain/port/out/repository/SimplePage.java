package co.edu.uco.core.domain.port.out.repository;

import co.edu.uco.core.domain.data.MessageData;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
@Setter
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
    public static SimplePage<MessageData> of(Page<MessageData> map) {
        return new SimplePage<>(map.getContent(), map.getNumber(), map.getSize(), map.getTotalElements(), map.getTotalPages());
    }
    public static <T> SimplePage<T> of(List<T> data, int currentPage, int pageSize, long totalItems, int totalPage) {
        return new SimplePage<>(data, currentPage, pageSize, totalItems, totalPage);
    }
}