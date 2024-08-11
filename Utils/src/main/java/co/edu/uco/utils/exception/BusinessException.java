package co.edu.uco.utils.exception;

import co.edu.uco.utils.exception.enumeration.ExceptionLocation;
import co.edu.uco.utils.exception.enumeration.ExceptionType;

import static co.edu.uco.utils.helper.UtilObject.getUtilObject;

public class BusinessException extends CrossWordsException {
    private ExceptionType type;
    private ExceptionLocation location;
    protected BusinessException(String userMessage, String technicalMessage, Exception rootException, ExceptionType type, ExceptionLocation location) {
        super(userMessage, technicalMessage, rootException);
        setLocation(location);
        setType(type);
    }

    public static BusinessException buildUserException(String userMessage) {
        return new BusinessException(userMessage, userMessage, null, ExceptionType.BUSINESS, null);
    }

    public static BusinessException buildTechnicalException(String technicalMessage) {
        return new BusinessException(null, technicalMessage, null, ExceptionType.TECHNICAL, null);
    }

    public static BusinessException buildTechnicalException(String userMessage, String technicalMessage) {
        return new BusinessException(userMessage, technicalMessage, null, ExceptionType.TECHNICAL, ExceptionLocation.APPLICATION);
    }

    public static BusinessException buildTechnicalException(String technicalMessage, Exception rootException, ExceptionLocation location) {
        return new BusinessException(null, technicalMessage, rootException, ExceptionType.TECHNICAL, location);
    }

    public ExceptionType getType() {
        return type;
    }

    public void setType(ExceptionType type) {
        this.type = getUtilObject().getDefaultIsNull(type, ExceptionType.GENERAL);
    }

    public ExceptionLocation getLocation() {
        return location;
    }

    public void setLocation(ExceptionLocation location) {
        this.location = getUtilObject().getDefaultIsNull(location, ExceptionLocation.GENERAL);
    }
}
