package co.edu.uco.infrastructure.adapter.secondary.presenter.serializer.impl.xml;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class ResponseXml<T> {
    private List<T> data;
    private List<String> errors;

    public ResponseXml() {
    }

    public ResponseXml(List<T> data, List<String> errors) {
        this.data = data;
        this.errors = errors;
    }

    // Getters and setters
    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
