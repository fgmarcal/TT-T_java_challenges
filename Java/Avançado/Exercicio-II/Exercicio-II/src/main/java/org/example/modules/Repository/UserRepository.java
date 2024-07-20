package org.example.modules.Repository;

import org.example.modules.Database.Database;
import org.example.modules.Entity.User.User;
import org.example.modules.Exception.EmailInvalidoException;
import org.example.modules.Exception.NomeInvalidoException;
import org.example.modules.Exception.UsuarioJaCadastradoException;
import org.example.modules.Exception.UsuarioNaoExisteException;

import java.util.List;
import java.util.Optional;

public class UserRepository implements IUserRepository{

    Database database = new Database();

    @Override
    public void save(User user) throws UsuarioJaCadastradoException {
        database.register(user);
    }

    @Override
    public void delete(int id) {
        try{
            Optional<User> user = findById(id);
            database.remove(user.get());
        }catch (UsuarioNaoExisteException e){
            e.getStackTrace();
        }
    }

    @Override
    public Optional<User> findById(int id) {
        List<User> dbList = database.retrieveAll();
        for (User user : dbList) {
            if (user.getId() == id) {
                return Optional.of(user);
            }
        }
        throw new UsuarioNaoExisteException("Usuário não existe");
    }


    @Override
    public Optional<User> findByEmail(String email) {
        List<User> dbList = database.retrieveAll();
        for (User user : dbList) {
            if (user.getEmail().equals(email)) {
                return Optional.of(user);
            }
        }
        throw new EmailInvalidoException("E-mail inválido");
    }

    @Override
    public Optional<User> findByName(String name) {
        List<User> dbList = database.retrieveAll();
        for (User user : dbList) {
            if (user.getEmail().equals(name)) {
                return Optional.of(user);
            }
        }
        throw new NomeInvalidoException("Nome inválido");
    }

    @Override
    public List<User> findAllUsers() {
        return database.retrieveAll();
    }
}
