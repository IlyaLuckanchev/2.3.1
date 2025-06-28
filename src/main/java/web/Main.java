package web;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import web.Config.AppConfig;
import web.Model.User;
import web.UserDao.UserDaoHibernateImpl;

public class Main {
    private static final User user1 = new User("Ilya", "Lukanchev");
    private static final User user2 = new User("Anna", "Anisimova");
    private static final User user3 = new User("Stanislav", "Ytukov");
    private static final User user4 = new User("Oleg", "Mongol");

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        UserDaoHibernateImpl userDaoHibernate = context.getBean(UserDaoHibernateImpl.class);
        userDaoHibernate.createUsersTable();

        context.close();
    }
}
