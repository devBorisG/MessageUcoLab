package co.edu.uco.infrastructure.adapter.secondary.presenter;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

public interface Presenter<T> {
    void presentRestSuccess(List<T> dto, HttpServletRequest request, HttpServletResponse response);
}
