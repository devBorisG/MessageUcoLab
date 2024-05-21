package co.edu.uco.core.domain.port.out.presenter;

public interface GenericPresenterPort<T> {
    void execute(T entity);
}
