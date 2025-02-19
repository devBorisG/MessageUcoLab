package co.edu.uco.infrastructure.adapter.secondary.presenter.serializer;

public abstract class AbstractSerializer implements SerializerType {
    private final String contentType;

    protected AbstractSerializer(String contentType) {
        this.contentType = contentType;
    }

    @Override
    public String getSupportedContentType() {
        return contentType;
    }

    @Override
    public boolean supports(String mediaType) {
        return getSupportedContentType().equalsIgnoreCase(mediaType) ||
                mediaType.equals("*/*") && isDefault();
    }

    protected boolean isDefault() {
        return false;
    }
}
