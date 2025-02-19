package co.edu.uco.core.domain.port.out.presenter;


import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

public interface PresenterPort<T> {
    void presentRestSuccess(List<T> dto, HttpServletRequest request);
}