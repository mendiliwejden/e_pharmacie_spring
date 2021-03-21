package com.project.e_pharmacie_spring.controllers;

import com.project.e_pharmacie_spring.models.User;
import com.project.e_pharmacie_spring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/users")
    public String getAllUser(Model model) {
        List<User> users = userService.listAll();
        model.addAttribute("users", users);
        return "users";
    }

    @RequestMapping("/adduser")
    public String adduser(Model model) {
        User user = new User();
        model.addAttribute("users", user);
        return "new_user";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveuser(@ModelAttribute("users") User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("users/edit/{id}")
    public String showUpdateFrom(@PathVariable("id") int id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("users", user);
        return "update_user";
    }

    @PostMapping("users/update/{id}")
    public String updateuser(@PathVariable("id") int id,@ModelAttribute("users") User user,
            BindingResult result, Model model) {
        if (result.hasErrors()) {
            
            return "404";
        }
        
        userService.saveUser(user);
        
        return "redirect:/users";
    }

    @GetMapping("users/delete/{id}")
    public String deletuser(@PathVariable("id") int id, Model model) {
        userService.deleteUser(id);
        // model.addAttribute("users",userService.listAll());
        return "redirect:/users";
    }
}