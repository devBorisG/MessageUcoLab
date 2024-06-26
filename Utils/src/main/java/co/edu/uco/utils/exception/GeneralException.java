package co.edu.uco.utils.exception;

import static co.edu.uco.utils.helper.UtilObject.getUtilObject;
import static co.edu.uco.utils.helper.UtilText.getUtilText;

public class GeneralException extends RuntimeException {
    private static final long serialVersionUID = -3393801537376736983L;
    private String userMessage;
    private String technicalMessage;
    private Exception rootException;

    public static GeneralException build(String technicalMessage) {
        return new GeneralException(null, technicalMessage, null);
    }

    public static GeneralException build(String technicalMessage, Exception rootException) {
        return new GeneralException(null, technicalMessage, rootException);
    }

    protected GeneralException(String userMessage, String technicalMessage, Exception rootException) {
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
        this.userMessage = getUtilText().trim(userMessage);
    }
    private void setTechnicalMessage(String technicalMessage) {
        this.technicalMessage = getUtilText().trim(technicalMessage);
    }
    private void setRootException(Exception rootException) {
        this.rootException = getUtilObject().getDefaultIsNull(rootException, new Exception());
    }

}
