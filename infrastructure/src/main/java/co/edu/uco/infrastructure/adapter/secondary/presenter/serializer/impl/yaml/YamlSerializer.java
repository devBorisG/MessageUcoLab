package co.edu.uco.infrastructure.adapter.secondary.presenter.serializer.impl.yaml;

import co.edu.uco.infrastructure.adapter.secondary.presenter.serializer.AbstractSerializer;
import co.edu.uco.utils.exception.CrossWordsException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

public class YamlSerializer extends AbstractSerializer {

    public YamlSerializer() {
        super("application/yaml");
    }
    @Override
    public <T> String serialize(T data) throws CrossWordsException {
        try{
            return new YAMLMapper().writeValueAsString(data);
        } catch (JsonProcessingException e) {
            throw new CrossWordsException("Error al serializar el objeto", "",e);
        }
    }
}
