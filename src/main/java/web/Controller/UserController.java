package web.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.Model.User;
import web.UserDaoImpl.UserServiceImpl;


@Controller
public class UserController {
    @Autowired
    private UserServiceImpl userServiceImpl;

    @GetMapping
    public String getAllUsers(Model model) {
        model.addAttribute("user", userServiceImpl.getAllUsers());
        return "user";
    }
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("user", new User());
        return "add-user";
    }
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userServiceImpl.deleteUser(id);
        return "redirect:/user";
    }
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        User user = userServiceImpl.getUserById(id);
        model.addAttribute("user", user);
        return "edit-user";
    }

}