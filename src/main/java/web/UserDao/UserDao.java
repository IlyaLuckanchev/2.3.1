package web.UserDao;

import web.Model.User;
import java.util.List;

public interface UserDao {
    List<User> getUser();
    void addUser();
    void deleteUser();
    void updateUser();
    void createUsersTable();
}
