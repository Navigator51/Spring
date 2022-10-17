package su.goodcat.spring.exceptions;

import su.goodcat.spring.constants.ErrorMessagesConstants;

public class BadStatusException extends RuntimeException{

    @Override
    public String getMessage() {

        return ErrorMessagesConstants.BAD_STATUS_FORMAT_ERROR;
    }
}
