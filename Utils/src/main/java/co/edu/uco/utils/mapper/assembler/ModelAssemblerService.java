package co.edu.uco.utils.mapper.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ModelAssemblerService implements ModelAssembler {

    private final ModelMapper modelMapper;

    public ModelAssemblerService() {
        this.modelMapper = new ModelMapper();
    }

    @Override
    public <D, E> D assembleDomain(E entity, Class<D> domainClass) {
        return modelMapper.map(entity, domainClass);
    }

    @Override
    public <D, E> E assembleEntity(D domain, Class<E> entityClass) {
        return modelMapper.map(domain, entityClass);
    }

    @Override
    public <E, T> T assembleDTO(E entity, Class<T> dtoClass) {
        return modelMapper.map(entity, dtoClass);
    }

    @Override
    public <T, E> E assembleEntityByDTO(T entity, Class<E> dtoClass) {
        return modelMapper.map(entity, dtoClass);
    }
}
