package co.edu.uco.infrastructure.adapter.secondary.repository.data;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static co.edu.uco.core.CrosswordsConstant.SINGLETON_SCOPE;

@Component
@Scope(SINGLETON_SCOPE)
public class MessageDataMapper  {
    private  final ModelMapper modelMapper;
    public MessageDataMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
}