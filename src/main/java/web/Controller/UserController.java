package web.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.Model.User;
import web.UserDaoImpl.UserServiceImpl;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @GetMapping
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("isFormMode", false);
        return "user";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("isFormMode", true);
        model.addAttribute("formAction", "/user/add");
        return "user";
    }

    @PostMapping("/add")
    public String addUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/user";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        model.addAttribute("isFormMode", true);
        model.addAttribute("formAction", "/user/edit/" + id);
        return "user";
    }

    @PostMapping("/edit/{id}")
    public String updateUser(@PathVariable Long id, @ModelAttribute("user") User user) {
        userService.updateUser(user.getName(), user.getSurName(), id);
        return "redirect:/user";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "redirect:/user";
    }
}

