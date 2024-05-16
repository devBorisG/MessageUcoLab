package co.edu.uco.core.port;

public interface GenericReturnPort <T,D>{
    T execute(D d);
}
