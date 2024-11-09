package co.edu.uco.core.mapper.entity;

public interface EntityMapper<E,D> {
    D mapperDomain(E entity);
    E mapperEntity(D domain);
}