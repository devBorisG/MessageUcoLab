package co.edu.uco.core.domain.port;

public interface GenericPort <T, R> {
    void execute(T entity, R response);
}
