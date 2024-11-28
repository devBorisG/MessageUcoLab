package co.edu.uco.utils.helper;

public enum EnumConstants {
    PULSAR_URL("pulsar://localhost:6650"),
    SIMPLE_PAGE_SORT("ASC"),
    SIMPLE_PAGE_QUERY("%");

    private final String value;

    EnumConstants(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
