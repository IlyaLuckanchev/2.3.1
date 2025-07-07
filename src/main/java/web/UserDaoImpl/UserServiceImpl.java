package web.UserDaoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.Model.User;
import web.UserDao.UserDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public List<User> getAllUsers() {
        return userDao.getUser();
    }

    @Override
    public void updateUser(String name, String surName, Long id) {
        userDao.updateUser(name, surName, id);
    }

    @Override
    public void deleteUser(Long id) {
        userDao.deleteUser(id);
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }
}
