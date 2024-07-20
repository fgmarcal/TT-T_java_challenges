package org.example.modules.Exception;

public class EmailInvalidoException extends RuntimeException{
    public EmailInvalidoException(String message){
        super(message);
    }
}
