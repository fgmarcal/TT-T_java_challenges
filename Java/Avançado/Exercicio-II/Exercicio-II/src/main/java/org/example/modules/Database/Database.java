package org.example.modules.Database;

import org.example.modules.Entity.User.User;
import org.example.modules.Exception.UsuarioJaCadastradoException;

import java.util.ArrayList;
import java.util.List;

public final class Database {

    private static List<User> usuarios;
    public Database(){
        usuarios = new ArrayList<>();
    }

    public void register(User user){
        boolean exists = usuarios.stream().anyMatch(users -> users.hashCode() == user.hashCode());
        if(exists){
            throw new UsuarioJaCadastradoException("Usuário já existe na base de dados");
        }
        this.usuarios.add(user);
    }

    public void remove(User user){
        try{
            this.usuarios.remove(user);
        }catch (Exception e){
            e.getStackTrace();
        }
    }

    public List<User> retrieveAll(){
        return (usuarios);
    }
}
