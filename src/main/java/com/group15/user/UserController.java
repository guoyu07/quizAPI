package com.group15.user;

import com.group15.category.Category;
import com.group15.category.Colour;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

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
        return "redirect:login/query?successful=true"; // the idea of flashing a message
    }
}
