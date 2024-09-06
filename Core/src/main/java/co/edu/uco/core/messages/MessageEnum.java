package co.edu.uco.core.messages;

public enum MessageEnum {

    TCH_001(MessageCatalogEnum.TCH_001, "Database not connected", "Unable to establish connection to %s database", TypeMessageEnum.TECHNICAL, CategoryMessageEnum.ERROR),
    TCH_002(MessageCatalogEnum.TCH_002, "Message Broker not connected", "Unable to establish connection to Message Broker", TypeMessageEnum.TECHNICAL, CategoryMessageEnum.ERROR),
    TCH_003(MessageCatalogEnum.TCH_003, "API Translate not connected", "Unable to establish connection to translate API", TypeMessageEnum.TECHNICAL, CategoryMessageEnum.ERROR),
    TCH_004(MessageCatalogEnum.TCH_004, "Cache not connected", "Unable to establish connection to cache", TypeMessageEnum.TECHNICAL, CategoryMessageEnum.ERROR),
    TCH_005(MessageCatalogEnum.TCH_005, "Parameters component not connected", "Unable to establish connection to Parameters component", TypeMessageEnum.TECHNICAL, CategoryMessageEnum.ERROR),
    TCH_006(MessageCatalogEnum.TCH_006, "Security component not connected", "Unable to establish connection to Security component", TypeMessageEnum.TECHNICAL, CategoryMessageEnum.ERROR),
    TCH_007(MessageCatalogEnum.TCH_007, "Key is null", "The message key is null", TypeMessageEnum.TECHNICAL, CategoryMessageEnum.ERROR),
    TCH_008(MessageCatalogEnum.TCH_008, "Key is empty", "Message code does not exist", TypeMessageEnum.TECHNICAL, CategoryMessageEnum.ERROR),
    TCH_009(MessageCatalogEnum.TCH_009, "Message not found", "Message code does not exist with %s key", TypeMessageEnum.TECHNICAL, CategoryMessageEnum.ERROR);

    private MessageCatalogEnum code;
    private String title;
    private String content;
    private TypeMessageEnum type;
    private CategoryMessageEnum category;

    MessageEnum(final MessageCatalogEnum code, final String title,final String content, final TypeMessageEnum type, final CategoryMessageEnum category) {
        this.code = code;
        this.title = title;
        this.content = content;
        this.type = type;
        this.category = category;
    }

    public MessageCatalogEnum getCode() {
        return code;
    }

    public void setCode(final MessageCatalogEnum code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    private void setTitle(final String title) {
        this.title = title;
    }

    public TypeMessageEnum getType() {
        return type;
    }

    private void setType(final TypeMessageEnum type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    private void setContent(final String content) {
        this.content = content;
    }

    public CategoryMessageEnum getCategory() {
        return category;
    }

    private void setCategory(final CategoryMessageEnum category) {
        this.category = category;
    }

    public Message getMessage() {
        return new Message(code, content, title, type, category);
    }
}
