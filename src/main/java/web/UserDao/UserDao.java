package web.UserDao;

import web.Model.User;
import java.util.List;

public interface UserDao {
    List<User> getUser();
    void addUser(User user);
    void deleteUser(User user);
    void updateUser(User user);
    void createUsersTable();
}
