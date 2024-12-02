package co.edu.uco.utils.helper;

public enum EnumConstants {
    PULSAR_URL("pulsar://localhost:6650"),
    SIMPLE_PAGE_SORT("ASC"),
    SIMPLE_PAGE_QUERY("%"),
    DATE_FORMAT("yyyy-MM-dd'T'HH:mm:ss.SSSSSS"),
    DEFAULT_UUID_STRING("00000000-0000-0000-0000-000000000000");

    private final String value;

    EnumConstants(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
