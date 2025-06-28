package web.UserDao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;
import web.Model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


public class UserDaoHibernateImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

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
    public void addUser(User user) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.persist(new User(name, lastName, age));
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUser(User user) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.createSQLQuery("DELETE FROM Users s WHERE id = :id").executeUpdate();
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateUser(User user) {

    }


    @Override
    @SuppressWarnings("unchecked")
    public List<User> getUser() {
        TypedQuery<User> query = entityManager.getEntityManagerFactory()
                .createEntityManager().createQuery("SELECT u FROM User u", User.class);
        return query.getResultList();
    }

    @Override
    public void addUser(User user) {
        entityManager.getEntityManagerFactory().createEntityManager().persist(user);
    }

}
