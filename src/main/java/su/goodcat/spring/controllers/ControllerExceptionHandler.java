package su.goodcat.spring.controllers;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import su.goodcat.spring.exceptions.BadStatusException;
import su.goodcat.spring.exceptions.EmployeeNotFoundException;
import su.goodcat.spring.exceptions.HimselfInvitationException;

import javax.validation.ValidationException;

import static su.goodcat.spring.constants.ErrorMessagesConstants.BAD_VALUES_FORMAT_ERROR;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(EmployeeNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public HttpEntity<String> employeeNotFound(EmployeeNotFoundException a) {
        return new HttpEntity<>(a.getMessage());
    }

    @ExceptionHandler(ValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public HttpEntity<String> badFormat(ValidationException a) {
        return new HttpEntity<>(BAD_VALUES_FORMAT_ERROR + a.getMessage());
    }

    @ExceptionHandler({HimselfInvitationException.class, BadStatusException.class})
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public HttpEntity<String> badInvitation(Exception a) {
        return new HttpEntity<>(a.getMessage());
    }

}
