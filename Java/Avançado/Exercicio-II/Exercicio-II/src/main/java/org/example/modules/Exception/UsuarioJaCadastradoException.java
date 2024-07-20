package org.example.modules.Exception;

public class UsuarioJaCadastradoException extends RuntimeException{
    public UsuarioJaCadastradoException(String message){
        super(message);
    }
}
