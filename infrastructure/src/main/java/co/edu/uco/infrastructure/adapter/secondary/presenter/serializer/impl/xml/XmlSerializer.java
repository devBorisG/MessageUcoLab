package co.edu.uco.infrastructure.adapter.secondary.presenter.serializer.impl.xml;

import co.edu.uco.infrastructure.adapter.secondary.presenter.serializer.AbstractSerializer;
import co.edu.uco.utils.exception.CrossWordsException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.List;

public class XmlSerializer extends AbstractSerializer {

    public XmlSerializer() {
        super("application/xml");
    }

    @Override
    public <T> String serialize(T data) throws CrossWordsException {
        try {
            ResponseXml<T> responseXml = new ResponseXml<>(List.of(data), List.of());
            JAXBContext context = JAXBContext.newInstance(ResponseXml.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            StringWriter writer = new StringWriter();
            marshaller.marshal(responseXml, writer);
            return writer.toString();
        } catch (JAXBException e) {
            throw new CrossWordsException("Error al serializar el objeto", "", e);
        }
    }
}
