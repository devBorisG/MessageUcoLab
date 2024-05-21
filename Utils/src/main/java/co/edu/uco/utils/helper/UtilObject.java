package co.edu.uco.utils.helper;

public final class UtilObject {
    private static final UtilObject INSTANCE = new UtilObject();
    private UtilObject() {}

    public static UtilObject getUtilObject() {
        return INSTANCE;
    }

    public <T> boolean isNull(T object) {
        return object == null;
    }

    public <T> T getDefaultIsNull(T object, T defaultValue) {
        return (isNull(object) ? defaultValue : object);
    }
}
