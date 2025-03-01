package co.edu.uco.infrastructure.adapter.secondary.presenter.serializer.impl.yaml;

import co.edu.uco.core.application.catalog.strategy.inmemory.enums.DetailMessageEnum;
import co.edu.uco.infrastructure.adapter.secondary.presenter.serializer.AbstractSerializer;
import co.edu.uco.utils.exception.CrossWordsException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static co.edu.uco.infrastructure.configuration.InfrastructureConstant.YAML_SERIALIZER_CONTENT_TYPE;

public final class YamlSerializer extends AbstractSerializer {
    public YamlSerializer() {
        super(YAML_SERIALIZER_CONTENT_TYPE);
    }
    @Override
    public <T> String serialize(T data) throws CrossWordsException {
        try{
            ObjectMapper mapper = new YAMLMapper();
            JavaTimeModule module = new JavaTimeModule();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
            module.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(formatter));
            mapper.registerModule(module);
            mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            return mapper.writeValueAsString(data);
        } catch (JsonProcessingException e) {
            throw CrossWordsException.build(DetailMessageEnum.TCH_018.getContent(), e);
        }
    }
}