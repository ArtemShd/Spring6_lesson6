package web.controller;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import web.model.User;
import web.service.UserServise;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserServise userServise;

    public UserController(UserServise userServise) {
        this.userServise = userServise;
    }

    @GetMapping
    public String showUsers(Model model) {
        model.addAttribute("users", userServise.getAllUsers());
        return "users";
    }

    @PostMapping("getUserById")
    public String getUserById(@RequestParam int id, Model model) {
        model.addAttribute("user", userServise.getUserById(id));
        return "user";
    }

    @PostMapping("/update")
    public String updateUser(User user) {
        userServise.updateUser(user);
        return "redirect:/users";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam int id) {
        userServise.deleteUser(id);
        return "redirect:/users";
    }

    @PostMapping("/saveUser")
    public String saveUser(User user) {
        userServise.saveUser(user);
        return "redirect:/users";
    }
}
