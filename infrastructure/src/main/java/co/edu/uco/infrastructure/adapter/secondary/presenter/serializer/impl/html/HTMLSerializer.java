package co.edu.uco.infrastructure.adapter.secondary.presenter.serializer.impl.html;

import co.edu.uco.core.application.catalog.strategy.inmemory.enums.DetailMessageEnum;
import co.edu.uco.infrastructure.adapter.secondary.presenter.serializer.AbstractSerializer;
import co.edu.uco.utils.exception.CrossWordsException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import static co.edu.uco.infrastructure.configuration.InfrastructureConstant.HTML_SERIALIZER_CONTENT_TYPE;

public class HTMLSerializer extends AbstractSerializer {
    public HTMLSerializer() {
        super(HTML_SERIALIZER_CONTENT_TYPE);
    }

    @Override
    public <T> String serialize(T data) {
        try {
            StringBuilder html = new StringBuilder();
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            String result = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(data);
            html.append("<html><body>");
            html.append("<pre>").append(result).append("</pre>");
            html.append("</body></html>");
            return html.toString();
        } catch (Exception e) {
            throw CrossWordsException.build(DetailMessageEnum.TCH_018.getContent(), e);
        }
    }
}
