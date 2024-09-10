package co.edu.uco.core.assembler.dto;

public interface DTOAssembler<T,D> {
    D assembleDomain(T dto);
    T assembleDTO(D domain);
}
