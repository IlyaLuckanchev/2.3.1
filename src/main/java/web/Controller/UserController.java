package web.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class UserController {
    @GetMapping("/user")
    public String getUserRedact (@RequestParam(required = false) Integer count) {
        return null;
    }
}
