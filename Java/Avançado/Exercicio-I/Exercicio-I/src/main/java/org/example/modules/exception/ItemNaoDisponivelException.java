package org.example.modules.exception;

public class ItemNaoDisponivelException extends RuntimeException{
    public ItemNaoDisponivelException(String message){
        super(message);
    }
}
