package org.example.modules.exception;

public class ItemNaoEncontradoException extends RuntimeException{
    public ItemNaoEncontradoException(String message){
        super(message);
    }
}
