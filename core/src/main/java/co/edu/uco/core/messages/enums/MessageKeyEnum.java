package co.edu.uco.core.messages.enums;

import co.edu.uco.utils.exception.CrossWordsException;
import co.edu.uco.utils.helper.UtilText;
import lombok.Getter;

import java.util.Arrays;

@Getter
public enum MessageKeyEnum {
    USR_001("USR_001", MessageSourceEnum.CRITICAL),
    USR_002("USR_002", MessageSourceEnum.CRITICAL),
    USR_003("USR_003", MessageSourceEnum.CRITICAL),
    TCH_001("TCH_001", MessageSourceEnum.CRITICAL),
    TCH_002("TCH_002", MessageSourceEnum.CRITICAL),
    TCH_003("TCH_003", MessageSourceEnum.CRITICAL),
    TCH_004("TCH_004", MessageSourceEnum.CRITICAL),
    TCH_005("TCH_005", MessageSourceEnum.CRITICAL),
    TCH_006("TCH_006", MessageSourceEnum.CRITICAL),
    TCH_007("TCH_007", MessageSourceEnum.CRITICAL),
    TCH_008("TCH_008", MessageSourceEnum.CRITICAL),
    TCH_009("TCH_009", MessageSourceEnum.CRITICAL),
    TCH_010("message:125", MessageSourceEnum.CACHE),
    TCH_011("1", MessageSourceEnum.DATABASE),
    FUN_001("FUN_001", MessageSourceEnum.CRITICAL),
    FUN_002("FUN_002", MessageSourceEnum.CRITICAL),
    FUN_003("FUN_003", MessageSourceEnum.CRITICAL),
    FUN_004("FUN_004", MessageSourceEnum.CRITICAL),
    FUN_005("FUN_005", MessageSourceEnum.CRITICAL);
    private final String key;
    private final MessageSourceEnum source;

    MessageKeyEnum(String key, MessageSourceEnum source) {
        this.key = key;
        this.source = source;
    }

    public static MessageKeyEnum of(String key) {
        if (UtilText.isEmptyOrNull(key)) {
            throw CrossWordsException.build(DetailMessageEnum.TCH_008.getContent());
        }
        return Arrays.stream(MessageKeyEnum.values()).filter(messageCatalogEnum
                        -> messageCatalogEnum.getKey().equals(key)).findFirst()
                .orElseThrow(() -> CrossWordsException.build(DetailMessageEnum.TCH_009.getContent()));
    }
}