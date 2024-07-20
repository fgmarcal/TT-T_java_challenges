package org.example.modules.Repository;

import org.example.modules.Entity.User.User;

import java.util.List;
import java.util.Optional;

public interface IUserRepository {

    public void save(User user);
    public void delete(int id);

    public Optional<User> findById(int id);
    public Optional<User> findByEmail(String email);
    public Optional<User> findByName(String name);
    public List<User> findAllUsers();
}
