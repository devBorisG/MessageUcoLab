package co.edu.uco.utils.exception;

import co.edu.uco.utils.exception.enumeration.ExceptionLocation;
import co.edu.uco.utils.exception.enumeration.ExceptionType;

import static co.edu.uco.utils.helper.UtilObject.getUtilObject;

public class CrossWordCustomException extends GeneralException{
    private ExceptionType type;
    private ExceptionLocation location;

    protected CrossWordCustomException(String userMessage, String technicalMessage, Exception rootException) {
        super(userMessage, technicalMessage, rootException);
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
