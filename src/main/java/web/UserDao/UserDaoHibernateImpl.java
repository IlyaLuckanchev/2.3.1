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
    public void createUsersTable() {
        Query query = entityManager.createNativeQuery(
                "CREATE TABLE IF NOT EXISTS user (" +
                        "id MEDIUMINT NOT NULL AUTO_INCREMENT, " +
                        "name VARCHAR(50), " +
                        "surName VARCHAR(50), " +
                        "PRIMARY KEY (id))");
        query.executeUpdate();
    }

    @Override
    @Transactional
    public void addUser() {
        Query query = entityManager.createNativeQuery(
                "INSERT INTO user (name, surName) VALUES (?, ?)"
        );
        query.setParameter(1, user.getName());
        query.setParameter(2, user.getSurName());
        query.executeUpdate();
    }

    @Override
    @Transactional
    public void deleteUser() {
        Query query = entityManager.createNativeQuery(
                "DELETE FROM user WHERE id = ?"
        );
        query.setParameter(1, user.getId());
        query.executeUpdate();
    }

    @Override
    @Transactional
    public void updateUser() {
        Query query = entityManager.createNativeQuery(
                "UPDATE user SET name = ?, surName = ? WHERE id = ?"
        );
        query.setParameter(1, user.getName());
        query.setParameter(2, user.getSurName());
        query.setParameter(3, user.getId());
        query.executeUpdate();
    }

    @Override
    @Transactional
    public List<User> getUser() {
        Query query = entityManager.createQuery("SELECT u FROM User u");
        return query.getResultList();
    }

}
