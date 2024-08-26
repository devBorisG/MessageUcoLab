package co.edu.uco.core.messages;

import lombok.Getter;

@Getter
public enum CatalogMessageEnum {
    USR_001("USR_001", MessageCatalogSource.CRITICAL),
    USR_002("USR_002",MessageCatalogSource.CRITICAL),
    USR_003("USR_003",MessageCatalogSource.CRITICAL);


    private final String key;
    private final MessageCatalogSource source;

    CatalogMessageEnum(String key, MessageCatalogSource source) {
        this.key = key;
        this.source = source;
    }
}
