package co.edu.uco.core.domain.port.out.presenter;

import java.util.List;

public interface PresenterPort<T> {
    void presentRestSuccess(List<T> dto);
}