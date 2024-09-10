package co.edu.uco.core.messages.enums;

import co.edu.uco.core.messages.Message;

public enum DetailMessageEnum {

    TCH_001(MessageKeyEnum.TCH_001, "Database not connected", "Unable to establish connection to %s database", MessageTypeEnum.TECHNICAL, MessageCategoryEnum.ERROR),
    TCH_002(MessageKeyEnum.TCH_002, "Message Broker not connected", "Unable to establish connection to Message Broker", MessageTypeEnum.TECHNICAL, MessageCategoryEnum.ERROR),
    TCH_003(MessageKeyEnum.TCH_003, "API Translate not connected", "Unable to establish connection to translate API", MessageTypeEnum.TECHNICAL, MessageCategoryEnum.ERROR),
    TCH_004(MessageKeyEnum.TCH_004, "Cache not connected", "Unable to establish connection to cache", MessageTypeEnum.TECHNICAL, MessageCategoryEnum.ERROR),
    TCH_005(MessageKeyEnum.TCH_005, "Parameters component not connected", "Unable to establish connection to Parameters component", MessageTypeEnum.TECHNICAL, MessageCategoryEnum.ERROR),
    TCH_006(MessageKeyEnum.TCH_006, "Security component not connected", "Unable to establish connection to Security component", MessageTypeEnum.TECHNICAL, MessageCategoryEnum.ERROR),
    TCH_007(MessageKeyEnum.TCH_007, "Key is null", "The message key is null", MessageTypeEnum.TECHNICAL, MessageCategoryEnum.ERROR),
    TCH_008(MessageKeyEnum.TCH_008, "Key is empty", "Message code does not exist", MessageTypeEnum.TECHNICAL, MessageCategoryEnum.ERROR),
    TCH_009(MessageKeyEnum.TCH_009, "Message not found", "Message code does not exist with %s key", MessageTypeEnum.TECHNICAL, MessageCategoryEnum.ERROR);

    private MessageKeyEnum code;
    private String title;
    private String content;
    private MessageTypeEnum type;
    private MessageCategoryEnum category;

    DetailMessageEnum(final MessageKeyEnum code, final String title, final String content, final MessageTypeEnum type, final MessageCategoryEnum category) {
        this.code = code;
        this.title = title;
        this.content = content;
        this.type = type;
        this.category = category;
    }

    public MessageKeyEnum getCode() {
        return code;
    }

    public void setCode(final MessageKeyEnum code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    private void setTitle(final String title) {
        this.title = title;
    }

    public MessageTypeEnum getType() {
        return type;
    }

    private void setType(final MessageTypeEnum type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    private void setContent(final String content) {
        this.content = content;
    }

    public MessageCategoryEnum getCategory() {
        return category;
    }

    private void setCategory(final MessageCategoryEnum category) {
        this.category = category;
    }

    public Message getMessage() {
        return new Message(code, content, title, type, category);
    }
}
