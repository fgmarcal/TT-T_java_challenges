package org.example.modules.Exception;

public class UsuarioNaoExisteException extends RuntimeException{
    public UsuarioNaoExisteException(String message){
        super(message);
    }
}
