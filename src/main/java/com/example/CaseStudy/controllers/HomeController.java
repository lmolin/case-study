package com.example.CaseStudy.controllers;

import com.example.CaseStudy.models.Project;
import com.example.CaseStudy.models.User;
import com.example.CaseStudy.services.UserService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.naming.Binding;

@Log
@Controller
public class HomeController {

    @Autowired
    UserService us;

    @ModelAttribute("user")
    public User initUser(){
        return new User();
    }

    //go to homepage
    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/settings")
    public String settings() {
        return "settings";
    }

    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }

    @PostMapping("/signup/new")
    public String newUser(@ModelAttribute("user") @Validated User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            log.warning("invalid credentials");
            return "signup";
        }

        us.saveUser(user);
        return "home";
    }

}
