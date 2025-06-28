package web.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import web.Model.User;
import web.UserDao.UserDao;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserDao userDao;

    @Autowired
    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userDao.getUser();
    }
}