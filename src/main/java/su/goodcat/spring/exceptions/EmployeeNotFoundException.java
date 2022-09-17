package su.goodcat.spring.exceptions;

import lombok.RequiredArgsConstructor;
import su.goodcat.spring.constants.ErrorMessagesConstants;

@RequiredArgsConstructor
public class EmployeeNotFoundException extends RuntimeException {

    private final long id;

    @Override
    public String getMessage() {

        return String.format(ErrorMessagesConstants.DELETE_EXISTED_USER_ERROR, id);
    }
}
