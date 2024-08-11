package co.edu.uco.utils.exception;

import co.edu.uco.utils.exception.enumeration.ExceptionLocation;
import co.edu.uco.utils.exception.enumeration.ExceptionType;

import static co.edu.uco.utils.helper.UtilObject.getDefaultIsNullObject;

public class CrossWordCustomException extends GeneralException{
    private ExceptionType type;
    private ExceptionLocation location;
    protected CrossWordCustomException(String userMessage, String technicalMessage, Exception rootException, ExceptionType type, ExceptionLocation location) {
        super(userMessage, technicalMessage, rootException);
        setLocation(location);
        setType(type);
    }

    public static CrossWordCustomException buildUserException(String userMessage) {
        return new CrossWordCustomException(userMessage, userMessage, null, ExceptionType.BUSINESS, null);
    }

    public static CrossWordCustomException buildTechnicalException(String technicalMessage) {
        return new CrossWordCustomException(null, technicalMessage, null, ExceptionType.TECHNICAL, null);
    }

    public static CrossWordCustomException buildTechnicalException(String userMessage, String technicalMessage) {
        return new CrossWordCustomException(userMessage, technicalMessage, null, ExceptionType.TECHNICAL, ExceptionLocation.APPLICATION);
    }

    public static CrossWordCustomException buildTechnicalException(String technicalMessage, Exception rootException, ExceptionLocation location) {
        return new CrossWordCustomException(null, technicalMessage, rootException, ExceptionType.TECHNICAL, location);
    }

    public ExceptionType getType() {
        return type;
    }

    public void setType(ExceptionType type) {
        this.type = getDefaultIsNullObject(type, ExceptionType.GENERAL);
    }

    public ExceptionLocation getLocation() {
        return location;
    }

    public void setLocation(ExceptionLocation location) {
        this.location = getDefaultIsNullObject(location, ExceptionLocation.GENERAL);
    }
}
