package co.edu.uco.utils.mapper.assembler;

public interface ModelAssembler {
    <D, E> D assembleDomain(E entity, Class<D> domainClass);
    <D, E> E assembleEntity(D domain, Class<E> entityClass);
    <E, T> T assembleDTO(E entity, Class<T> dtoClass);
    <E, T> T assembleEntityByDTO(E entity, Class<T> dtoClass);
}
