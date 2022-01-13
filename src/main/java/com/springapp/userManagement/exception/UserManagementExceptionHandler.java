package com.springapp.userManagement.exception;


import org.apache.catalina.User;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class UserManagementExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> handleUserNotFoundException(UserNotFoundException e,
                                                              HttpServletRequest request) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(WeakPasswordException.class)
    public ResponseEntity<String> handleWeakPasswordException(WeakPasswordException e,
                                                              HttpServletRequest request) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(UserDoesNotHaveCarsException.class)
    public ResponseEntity<String> handleUserDoesNotHaveCarsException(UserDoesNotHaveCarsException e,
                                                                     HttpServletRequest request) {

        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(CarNotFoundException.class)
    public ResponseEntity<String> handleCarNotFoundException(CarNotFoundException e,
                                                             HttpServletRequest request){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
}

