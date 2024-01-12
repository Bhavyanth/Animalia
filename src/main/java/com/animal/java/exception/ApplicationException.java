package com.animal.java.exception;

public class ApplicationException extends RuntimeException{
    public ApplicationException(String msg, Exception exception){
        super(msg, exception);
    }
    public ApplicationException(String msg){
        super(msg);
    }
}
