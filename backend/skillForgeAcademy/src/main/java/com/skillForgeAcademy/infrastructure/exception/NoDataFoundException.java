package com.skillForgeAcademy.infrastructure.exception;

public class NoDataFoundException extends RuntimeException{
    public NoDataFoundException(String message){
        super(message);
    }
}
