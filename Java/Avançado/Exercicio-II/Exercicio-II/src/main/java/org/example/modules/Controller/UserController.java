package org.example.modules.Controller;

import org.example.modules.Entity.User.CreateUserDTO;
import org.example.modules.Entity.User.User;
import org.example.modules.Exception.EmailInvalidoException;
import org.example.modules.Exception.NomeInvalidoException;
import org.example.modules.Exception.UsuarioJaCadastradoException;
import org.example.modules.Exception.UsuarioNaoExisteException;
import org.example.modules.Service.IUserService;
import org.example.modules.Service.UserService;

import java.util.List;
import java.util.Optional;

public class UserController {

    IUserService userService;
    public UserController(){
        userService = new UserService();
    }

    //@PostMethod
    public void createUser(CreateUserDTO dto){
        try{
            userService.createUser(dto);
        }catch (UsuarioJaCadastradoException e){
            System.out.println(e.getMessage());
            e.getStackTrace();
        } catch (Exception e){
            System.out.println(e.getMessage());
            e.getStackTrace();
        }
    }

    //@GetMethod
    public Optional<User> getUserByName(String name){
        try {
            return userService.retrieveUserByName(name);
        }catch (NomeInvalidoException e){
            System.out.println(e.getMessage());
            e.getStackTrace();
        }catch (Exception e){
            e.getStackTrace();
        }
        return Optional.empty();
    }

    //@GetMethod
    public Optional<User> getUserByEmail(String email){
        try {
            return userService.retrieveUserByEmail(email);
        }catch (EmailInvalidoException e){
            System.out.println(e.getMessage());
            e.getStackTrace();
        }catch (Exception e){
            e.getStackTrace();
        }
        return Optional.empty();
    }

    //@GetMethod
    public Optional<User> getUserById(int id){
        try{
            return userService.retrieveUserById(id);
        }catch (UsuarioNaoExisteException e){
            System.out.println(e.getMessage());
            e.getStackTrace();
        }catch (Exception e){
            e.getStackTrace();
        }
        return Optional.empty();
    }

    public List<User> getAllUsers(){
        return userService.retrieveAllUsers();
    }

    //@DeleteMethod
    public void deleteUser(int id){
        try{
            userService.deleteUser(id);
        }catch (Exception e){
            System.out.printf(e.getMessage());
            e.getStackTrace();
        }
    }
}
