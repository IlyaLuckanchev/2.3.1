package web.UserDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.Model.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDaoHibernateImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    User user;

    @Override
    @Transactional
    public void addUser(User user) {
        Query query = entityManager.createNativeQuery(
                "INSERT INTO user (name, surname) VALUES (?, ?)"
        );
        query.setParameter(1, user.getName());
        query.setParameter(2, user.getSurName());
        query.executeUpdate();
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        Query query = entityManager.createNativeQuery(
                "DELETE FROM user WHERE id = ?"
        );
        query.setParameter(1, id);
        query.executeUpdate();
    }

    @Override
    @Transactional
    public void updateUser(String name, String surName, Long id) {
        Query query = entityManager.createNativeQuery(
                "UPDATE user SET name = ?, surname = ? WHERE id = ?"
        );
        query.setParameter(1, name);
        query.setParameter(2, surName);
        query.setParameter(3, id);
        query.executeUpdate();
    }

    @Override
    @Transactional
    public List<User> getUser() {
        Query query = entityManager.createQuery("SELECT u FROM User u");
        return query.getResultList();
    }

}
