package co.edu.uco.infrastructure.adapter.secondary.presenter.serializer.impl.yaml;

import co.edu.uco.core.application.catalog.strategy.inmemory.enums.DetailMessageEnum;
import co.edu.uco.infrastructure.adapter.secondary.presenter.serializer.AbstractSerializer;
import co.edu.uco.utils.exception.CrossWordsException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import static co.edu.uco.infrastructure.configuration.InfrastructureConstant.YAML_SERIALIZER_CONTENT_TYPE;

public final class YamlSerializer extends AbstractSerializer {
    public YamlSerializer() {
        super(YAML_SERIALIZER_CONTENT_TYPE);
    }
    @Override
    public <T> String serialize(T data) throws CrossWordsException {
        try{
            return new YAMLMapper().writeValueAsString(data);
        } catch (JsonProcessingException e) {
            throw CrossWordsException.build(DetailMessageEnum.TCH_018.getContent(), e);
        }
    }
}