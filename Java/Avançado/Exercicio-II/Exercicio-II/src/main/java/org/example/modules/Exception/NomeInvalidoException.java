package org.example.modules.Exception;

public class NomeInvalidoException extends RuntimeException{
    public NomeInvalidoException(String message){
        super(message);
    }
}
