package com.springapp.userManagement.exception;

public class UserDoesNotHaveCarsException extends RuntimeException{
    public UserDoesNotHaveCarsException(String msg){
        super(msg);
    }
}
