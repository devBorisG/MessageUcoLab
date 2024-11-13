package co.edu.uco.core.mapper.entity;

public interface EntityMapper<E,D,T> {
    D mapperDomain(E entity);
    E mapperEntity(D domain);
    T mapperDTO(E entity);
}