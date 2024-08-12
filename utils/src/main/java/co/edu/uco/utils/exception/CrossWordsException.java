package co.edu.uco.utils.exception;

import static co.edu.uco.utils.helper.UtilObject.getDefaultIsNullObject;
import static co.edu.uco.utils.helper.UtilText.trim;

public class CrossWordsException extends RuntimeException {
    private static final long serialVersionUID = -3393801537376736983L;
    private String userMessage;
    private String technicalMessage;
    private Exception rootException;

    public static CrossWordsException build(String technicalMessage) {
        return new CrossWordsException(null, technicalMessage, null);
    }

    public static CrossWordsException build(String technicalMessage, Exception rootException) {
        return new CrossWordsException(null, technicalMessage, rootException);
    }

    protected CrossWordsException(String userMessage, String technicalMessage, Exception rootException) {
        super();
        setUserMessage(userMessage);
        setTechnicalMessage(technicalMessage);
        setRootException(rootException);
    }

    public String getUserMessage() {
        return userMessage;
    }
    public String getTechnicalMessage() {
        return technicalMessage;
    }
    public Exception getRootException() {
        return rootException;
    }
    private void setUserMessage(String userMessage) {
        this.userMessage = trim(userMessage);
    }
    private void setTechnicalMessage(String technicalMessage) {
        this.technicalMessage = trim(technicalMessage);
    }
    private void setRootException(Exception rootException) {
        this.rootException = getDefaultIsNullObject(rootException, new Exception());
    }

}
