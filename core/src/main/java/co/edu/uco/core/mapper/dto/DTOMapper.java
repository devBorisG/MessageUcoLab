package co.edu.uco.core.mapper.dto;

public interface DTOMapper<T,D> {
    D mapperDomain(T dto);
    T mapperDTO(D domain);
}