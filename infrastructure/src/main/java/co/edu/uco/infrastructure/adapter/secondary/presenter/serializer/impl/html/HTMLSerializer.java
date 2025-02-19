package co.edu.uco.infrastructure.adapter.secondary.presenter.serializer.impl.html;

import co.edu.uco.core.application.catalog.strategy.inmemory.enums.DetailMessageEnum;
import co.edu.uco.infrastructure.adapter.secondary.presenter.serializer.AbstractSerializer;
import co.edu.uco.utils.exception.CrossWordsException;

import static co.edu.uco.infrastructure.configuration.InfrastructureConstant.HTML_SERIALIZER_CONTENT_TYPE;

public class HTMLSerializer extends AbstractSerializer {
    public HTMLSerializer() {
        super(HTML_SERIALIZER_CONTENT_TYPE);
    }

    @Override
    public <T> String serialize(T data) {
        try {
            StringBuilder html = new StringBuilder();
            html.append("<html><body>");
            html.append("<pre>").append(data.toString()).append("</pre>");
            html.append("</body></html>");
            return html.toString();
        } catch (Exception e) {
            throw CrossWordsException.build(DetailMessageEnum.TCH_018.getContent(), e);
        }
    }
}
