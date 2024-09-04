package co.edu.uco.core;

public enum CrosswordConstants {
    SINGLETON("singleton"),
    PROTOTYPE("prototype");

    private final String value;

    CrosswordConstants(String value) {
        this.value = value;
    }
    public final String getValue() {
        return value;
    }
}