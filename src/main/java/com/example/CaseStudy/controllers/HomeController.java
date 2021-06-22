package com.example.CaseStudy.controllers;

import com.example.CaseStudy.models.Project;
import com.example.CaseStudy.models.User;
import com.example.CaseStudy.security.AppUserDetailsService;
import com.example.CaseStudy.services.ProjectService;
import com.example.CaseStudy.services.UserService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Log
@Controller
public class HomeController {

    @Autowired
    ProjectService ps;

    @Autowired
    UserService us;

    @ModelAttribute("user")
    public User initUser(){
        return new User();
    }

    //go to homepage
    @GetMapping("/home")
    public String home(Model model) {
        List<Project> projects = ps.getAllProjects();
        model.addAttribute("projects", projects);
        return "projects";
    }

    //go to login page
    @GetMapping("/login")
    public String login(){
        return "login";
    }

    //go to sign up page
    @GetMapping("/signup")
    public String signup(){
        return "signup";
    }

    @PostMapping("/signup")
    public String registerUser(@ModelAttribute("user") User user, BindingResult result, Model model) {

        if (result.hasErrors()) {
            log.warning("Invalid input");
            return "signup";
        }

        model.addAttribute("user", user);
        us.saveUser(user);

        return "redirect:../projects";
    }

}
