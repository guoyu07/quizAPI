package com.group15.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // form new user
    @RequestMapping("/register")
    public String formNewUser(Model model){
        model.addAttribute("user", new User());
        return "register";
    }

    // Add a user
    @RequestMapping(value = "/users" , method = RequestMethod.POST)
    public String addUser(@Valid User user){
        userRepository.save(user);
        return "redirect:login/";
    }

    @RequestMapping("/users")
    public String listUsers(Model model){
        Iterable<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "user/leaderboard";
    }
}
