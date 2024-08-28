package co.edu.uco.core.assembler.pojo;

public class Message {
    private String id;
    private String code;
    private String title;
    private String content;
    private String type;
    private String category;
    private String status;
    private String application;
    private String functionality;

    public Message(String id) {
        this.id = id;
        this.code = getCode();
        this.title = getTitle();
        this.content = getContent();
        this.type = getType();
        this.category = getCategory();
        this.status = getStatus();
        this.application = getApplication();
        this.functionality = getFunctionality();
    }

    public Message(String id, String code, String title, String content, String type, String category, String status, String application, String functionality) {
        this.id = id;
        this.code = code;
        this.title = title;
        this.content = content;
        this.type = type;
        this.category = category;
        this.status = status;
        this.application = application;
        this.functionality = functionality;
    }

    public Message() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public String getFunctionality() {
        return functionality;
    }

    public void setFunctionality(String functionality) {
        this.functionality = functionality;
    }
}
