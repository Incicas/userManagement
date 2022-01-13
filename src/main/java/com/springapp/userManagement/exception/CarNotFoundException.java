package com.springapp.userManagement.exception;

public class CarNotFoundException extends RuntimeException{
    public CarNotFoundException(String msg){
        super(msg);
    }
}
