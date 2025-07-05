package web.UserDaoImpl;

import web.Model.User;
import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    void updateUser(String name, String surName, Long id);
    void deleteUser(Long id);
    void addUser(User user);
    User getUserById(Long id);
}
