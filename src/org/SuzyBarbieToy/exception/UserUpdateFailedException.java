package org.SuzyBarbieToy.exception;

public class UserUpdateFailedException extends RuntimeException{
    public UserUpdateFailedException(String message){
        super(message);
    }
}