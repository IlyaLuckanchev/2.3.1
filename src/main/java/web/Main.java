package web;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import web.Config.AppConfig;
import web.Model.User;
import web.UserDaoImpl.UserService;
import web.UserDaoImpl.UserServiceImpl;


public class Main {
    private static final User user1 = new User("Ilya", "Lukanchev");
    private static final User user2 = new User("Anna", "Anisimova");
    private static final User user3 = new User("Stanislav", "Ytukov");
    private static final User user4 = new User("Oleg", "Mongol");

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserServiceImpl.class);
        userService.addUser(user1);
        userService.addUser(user2);
        userService.addUser(user3);
        userService.deleteUser(2L);
        userService.updateUser("Nicola", "Svetozarov", 3L);
        System.out.println(userService.getAllUsers());
        context.close();
    }
}
