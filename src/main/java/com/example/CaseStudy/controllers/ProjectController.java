package com.example.CaseStudy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProjectController {

    //go to homepage
    @GetMapping("/home")
    public String home() {
        return "home";
    }

    //go to new project
    @GetMapping("/projects/new")
    public String newProject() {return "newproject";}

    @PostMapping("/projects/")

    //go to all projects
    @GetMapping("/projects")
    public String projects() {return "projects";}

    //go to archived projects
    @GetMapping("/projects/archived")
    public String archivedProjects() {return "archived";}
}