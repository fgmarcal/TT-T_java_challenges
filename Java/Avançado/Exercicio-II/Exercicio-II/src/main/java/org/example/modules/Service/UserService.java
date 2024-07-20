package org.example.modules.Service;

import org.example.modules.Entity.User.User;
import org.example.modules.Entity.User.CreateUserDTO;
import org.example.modules.Exception.EmailInvalidoException;
import org.example.modules.Exception.IdInvalidoException;
import org.example.modules.Exception.NomeInvalidoException;
import org.example.modules.Repository.IUserRepository;
import org.example.modules.Repository.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserService implements IUserService{

    IUserRepository userRepository = new UserRepository();

    @Override
    public void createUser(CreateUserDTO dto) {
        try {
            checaNome(dto.name());
            checaEmail(dto.email());
            User user = new User(dto.name(), dto.email(), dto.idade());
            userRepository.save(user);
            System.out.println("Usuário Criado");
        }catch (NomeInvalidoException e){
            System.out.println(e.getMessage());
            e.getStackTrace();
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.getStackTrace();
        }
    }

    @Override
    public void deleteUser(int id) {
        try{
            retrieveUserById(id);
            userRepository.delete(id);
            System.out.println("Usuário Deletado");
        }catch (IdInvalidoException e){
            System.out.println(e.getMessage());
            e.getStackTrace();
        }catch (Exception e){
            e.getStackTrace();
        }
    }

    @Override
    public Optional<User> retrieveUserById(int id) {
        try{
            checaId(id);
        }catch (IdInvalidoException e){
            System.out.println(e.getMessage());
            e.getStackTrace();
        }
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> retrieveUserByEmail(String email) {
        try{
            checaEmail(email);
        }catch (EmailInvalidoException e){
            System.out.println(e.getMessage());
            e.getStackTrace();
        }
        return userRepository.findByEmail(email);
    }

    @Override
    public Optional<User> retrieveUserByName(String name) {
        try{
            checaNome(name);
        }catch (NomeInvalidoException e){
            System.out.println(e.getMessage());
            e.getStackTrace();
        }
        return userRepository.findByName(name);
    }

    @Override
    public List<User> retrieveAllUsers() {
        return userRepository.findAllUsers();
    }

    private void checaNome(String nome){
        String regexForName = "^[A-Z][a-z]*( [A-Z][a-z]*)*$";
        Pattern pattern = Pattern.compile(regexForName);
        Matcher nameMatcher = pattern.matcher(nome);
        if(!nameMatcher.find()){
            throw new NomeInvalidoException("Nome inválido");
        }
    }

    private void checaEmail(String email){
        String regexForEmail = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(regexForEmail);
        Matcher emailMatcher = pattern.matcher(email);
        if(!emailMatcher.find()){
            throw new EmailInvalidoException("E-mail inválido");
        }
    }

    private void checaId(int id){
        if(id <= 0){
            throw new IdInvalidoException("Id inválido");
        }
    }
}
