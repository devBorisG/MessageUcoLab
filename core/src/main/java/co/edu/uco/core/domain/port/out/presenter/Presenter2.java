package co.edu.uco.core.domain.port.out.presenter;

import co.edu.uco.core.application.catalog.strategy.inmemory.enums.DetailMessageEnum;

import java.util.List;

public interface Presenter2<T> {
    void presentRestSuccess(List<T> dto);
}
