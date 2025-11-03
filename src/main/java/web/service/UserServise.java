package web.service;

import web.model.User;

import java.util.List;

public interface UserServise {
    List<User> getAllUsers();
    void saveUser(User user);
    void updateUser(User user);
    void deleteUser(int id);
    User getUserById(int id);
}
