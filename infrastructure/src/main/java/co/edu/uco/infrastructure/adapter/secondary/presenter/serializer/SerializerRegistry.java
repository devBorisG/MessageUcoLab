package co.edu.uco.infrastructure.adapter.secondary.presenter.serializer;

import co.edu.uco.utils.exception.BusinessException;
import co.edu.uco.utils.exception.CrossWordsException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class SerializerRegistry {
    private final List<SerializerType> serializers;

    public SerializerRegistry(List<SerializerType> serializers) {
        this.serializers = serializers;
    }

    public SerializerType getSerializerForMediaType(String mediaType) throws BusinessException {
        Optional<SerializerType> serializer = serializers.stream()
                .filter(s -> s.supports(mediaType))
                .findFirst();

        return serializer.orElseThrow(() ->
                CrossWordsException.build("No se encontró un serializador para el tipo de contenido: " + mediaType));
    }
}
