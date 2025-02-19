package co.edu.uco.core.application.catalog.strategy.inmemory.enums;

import co.edu.uco.utils.exception.CrossWordsException;
import co.edu.uco.utils.helper.UtilText;
import lombok.Getter;

import java.util.Arrays;

@Getter
public enum MessageKeyEnum {
    TCH_001("TCH_001", MessageSourceEnum.CRITICAL),
    TCH_002("TCH_002", MessageSourceEnum.CRITICAL),
    TCH_003("TCH_003", MessageSourceEnum.CRITICAL),
    TCH_004("TCH_004", MessageSourceEnum.CRITICAL),
    TCH_005("TCH_005", MessageSourceEnum.CRITICAL),
    TCH_006("TCH_006", MessageSourceEnum.CRITICAL),
    TCH_007("TCH_007", MessageSourceEnum.CRITICAL),
    TCH_008("TCH_008", MessageSourceEnum.CRITICAL),
    TCH_009("TCH_009", MessageSourceEnum.CRITICAL),
    TCH_010("TCH_010", MessageSourceEnum.CRITICAL),
    TCH_011("TCH_011", MessageSourceEnum.CRITICAL),
    TCH_012("TCH_012", MessageSourceEnum.CRITICAL),
    TCH_013("TCH_013", MessageSourceEnum.CRITICAL),
    TCH_014("TCH_014", MessageSourceEnum.CRITICAL),
    TCH_015("TCH_015", MessageSourceEnum.CRITICAL),
    TCH_016("TCH_016", MessageSourceEnum.CRITICAL),
    TCH_017("TCH_017", MessageSourceEnum.CRITICAL),
    TCH_018("TCH_018", MessageSourceEnum.CRITICAL),
    TCH_019("TCH_019", MessageSourceEnum.CRITICAL),
    TCH_020("TCH_020", MessageSourceEnum.CRITICAL),
    FUN_001("FUN_001", MessageSourceEnum.CRITICAL),
    FUN_002("FUN_002", MessageSourceEnum.CRITICAL),
    FUN_003("FUN_003", MessageSourceEnum.CRITICAL),
    FUN_004("FUN_004", MessageSourceEnum.CRITICAL),
    FUN_005("FUN_005", MessageSourceEnum.CRITICAL),
    FUN_006("FUN_006", MessageSourceEnum.CACHE),
    FUN_007("FUN_007", MessageSourceEnum.DATABASE),
    FUN_008("FUN_008", MessageSourceEnum.DATABASE),
    FUN_009("FUN_009", MessageSourceEnum.CACHE),
    FUN_010("FUN_010", MessageSourceEnum.FILE),
    FUN_011("FUN_011", MessageSourceEnum.CRITICAL),
    FUN_012("FUN_012", MessageSourceEnum.CRITICAL),
    FUN_013("FUN_013", MessageSourceEnum.CACHE),
    FUN_014("FUN_014", MessageSourceEnum.CACHE),
    FUN_015("FUN_015", MessageSourceEnum.CACHE),
    FUN_016("FUN_016", MessageSourceEnum.CRITICAL),
    FUN_017("FUN_017", MessageSourceEnum.CRITICAL),
    FUN_018("FUN_018", MessageSourceEnum.CRITICAL),
    FUN_019("FUN_019", MessageSourceEnum.CRITICAL),
    FUN_020("FUN_020", MessageSourceEnum.CRITICAL),
    FUN_021("FUN_021", MessageSourceEnum.CRITICAL),
    FUN_022("FUN_022", MessageSourceEnum.CRITICAL),
    FUN_023("FUN_023", MessageSourceEnum.CRITICAL),
    FUN_024("FUN_024", MessageSourceEnum.NETWORK);

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