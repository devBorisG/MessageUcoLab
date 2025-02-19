package co.edu.uco.infrastructure.adapter.secondary.presenter.serializer.impl.json;

import co.edu.uco.infrastructure.adapter.secondary.presenter.serializer.AbstractSerializer;
import co.edu.uco.utils.exception.CrossWordsException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonSerializer extends AbstractSerializer {

    public JsonSerializer() {
        super("application/json");
    }

    @Override
    public <T> String serialize(T data) throws CrossWordsException {
        try{
            return new ObjectMapper().writeValueAsString(data);
        } catch (JsonProcessingException e) {
            throw new CrossWordsException("Error al serializar el objeto", "",e);
        }
    }

    @Override
    protected boolean isDefault() {
        return true;
    }
}
