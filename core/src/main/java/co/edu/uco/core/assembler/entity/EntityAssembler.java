package co.edu.uco.core.assembler.entity;

public interface EntityAssembler<E,D> {
    D assembleDomain(E entity);
    E assembleEntity(D domain);
}
