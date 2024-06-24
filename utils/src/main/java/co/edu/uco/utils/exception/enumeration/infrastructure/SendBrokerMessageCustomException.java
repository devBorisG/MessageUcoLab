package co.edu.uco.utils.exception.enumeration.infrastructure;

import co.edu.uco.utils.exception.GeneralException;
import co.edu.uco.utils.exception.enumeration.ExceptionLocation;
import co.edu.uco.utils.exception.enumeration.ExceptionType;

import static co.edu.uco.utils.helper.UtilObject.getUtilObject;

public class SendBrokerMessageCustomException extends GeneralException {
    private ExceptionType type;
    private ExceptionLocation location;

    protected SendBrokerMessageCustomException(String userMessage, String technicalMessage, Exception rootException, ExceptionType type, ExceptionLocation location) {
        super(userMessage, technicalMessage, rootException);
        setLocation(location);
        setType(type);
    }

    public static SendBrokerMessageCustomException buildUserException(String userMessage) {
        return new SendBrokerMessageCustomException(userMessage, userMessage, null, ExceptionType.BUSINESS, null);
    }

    public static SendBrokerMessageCustomException buildTechnicalException(String technicalMessage) {
        return new SendBrokerMessageCustomException(null, technicalMessage, null, ExceptionType.TECHNICAL, null);
    }

    public static SendBrokerMessageCustomException buildTechnicalException(String userMessage, String technicalMessage) {
        return new SendBrokerMessageCustomException(userMessage, technicalMessage, null, ExceptionType.TECHNICAL, ExceptionLocation.APPLICATION);
    }

    public static SendBrokerMessageCustomException buildTechnicalException(String technicalMessage, Exception rootException) {
        return new SendBrokerMessageCustomException(null, technicalMessage, rootException, ExceptionType.TECHNICAL, ExceptionLocation.INFRASTRUCTURE);
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