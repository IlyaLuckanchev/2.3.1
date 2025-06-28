package web.UserDao;

import web.Model.User;
import java.util.List;

public interface UserDao {
    List<User> getUser();
    void addUser(User user);
    void deleteUser(Long id);
    void updateUser(String name, String surName, Long id);
}
