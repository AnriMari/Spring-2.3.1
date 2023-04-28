package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
public class UserController {

    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String main(Model model) {
        model.addAttribute("listUser",userService.getList());
        return "users";
    }
    @GetMapping("/createUser")
    public String createUserForm(Model model) {
        model.addAttribute("user", new User());
        return "createUser";
    }
    @PostMapping()
    public String save(@ModelAttribute("user") User theuser){
        userService.addUser(theuser);
        return "redirect:/";
    }
    @GetMapping("/editUser/{id}")
    public String updateUser(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "updateUser";
    }
    @PostMapping("/updateUser")
    public String update(@ModelAttribute("update") User user) {
        userService.updateUser(user);
        return "redirect:/";
    }

    @DeleteMapping("/deleteUser/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }
}
