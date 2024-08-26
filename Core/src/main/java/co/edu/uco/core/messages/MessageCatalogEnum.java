package co.edu.uco.core.messages;

import lombok.Getter;

@Getter
public enum MessageCatalogEnum {
    USR_001("USR_001", MessageCatalogSource.CRITICAL),
    USR_002("USR_002",MessageCatalogSource.CRITICAL),
    USR_003("USR_003",MessageCatalogSource.CRITICAL);


    private final String key;
    private final MessageCatalogSource source;

    MessageCatalogEnum(String key, MessageCatalogSource source) {
        this.key = key;
        this.source = source;
    }
}
