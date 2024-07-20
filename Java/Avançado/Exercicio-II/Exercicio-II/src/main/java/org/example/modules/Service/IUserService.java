package org.example.modules.Service;

import org.example.modules.Entity.User.User;
import org.example.modules.Entity.User.CreateUserDTO;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    public void createUser(CreateUserDTO dto);
    public void deleteUser(int id);

    public Optional<User> retrieveUserById(int id);
    public Optional<User> retrieveUserByEmail(String email);
    public Optional<User> retrieveUserByName(String name);
    public List<User> retrieveAllUsers();
}
