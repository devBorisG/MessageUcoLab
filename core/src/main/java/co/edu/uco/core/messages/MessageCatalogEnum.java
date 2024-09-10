package co.edu.uco.core.messages;

import co.edu.uco.utils.exception.CrossWordsException;
import co.edu.uco.utils.helper.UtilText;
import lombok.Getter;

import java.util.Arrays;

@Getter
public enum MessageCatalogEnum {
    USR_001("USR_001", MessageCatalogSource.CRITICAL),
    USR_002("USR_002",MessageCatalogSource.CRITICAL),
    USR_003("USR_003",MessageCatalogSource.CRITICAL),
    TCH_001("TCH_001",MessageCatalogSource.CRITICAL),
    TCH_002("TCH_002",MessageCatalogSource.CRITICAL),
    TCH_003("TCH_003",MessageCatalogSource.CRITICAL),
    TCH_004("TCH_004",MessageCatalogSource.CRITICAL),
    TCH_005("TCH_005",MessageCatalogSource.CRITICAL),
    TCH_006("TCH_006",MessageCatalogSource.CRITICAL),
    TCH_007("TCH_007",MessageCatalogSource.CRITICAL),
    TCH_008("TCH_008",MessageCatalogSource.CRITICAL),
    TCH_009("TCH_009",MessageCatalogSource.CRITICAL);

    private final String key;
    private final MessageCatalogSource source;

    MessageCatalogEnum(String key, MessageCatalogSource source) {
        this.key = key;
        this.source = source;
    }

    public static MessageCatalogEnum of(String key) {
        if (UtilText.isEmptyOrNull(key)) {
            throw CrossWordsException.build(MessageEnum.TCH_008.getContent());
        }
        return Arrays.stream(MessageCatalogEnum.values()).filter(messageCatalogEnum
                        -> messageCatalogEnum.getKey().equals(key)).findFirst()
                .orElseThrow(() -> CrossWordsException.build(MessageEnum.TCH_009.getContent()));
    }
}