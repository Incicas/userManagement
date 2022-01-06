package com.springapp.userManagement.exception;

public class WeakPasswordException extends RuntimeException{

    public WeakPasswordException(String msg){
        super(msg);
    }
}
