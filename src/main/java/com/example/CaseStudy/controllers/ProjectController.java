package com.example.CaseStudy.controllers;

import com.example.CaseStudy.models.Project;
import com.example.CaseStudy.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;

@Controller
public class ProjectController {

    @Autowired
    ProjectService ps;

    @ModelAttribute("project")
    public Project initProject(){
        return new Project();
    }

    //go to new project
    @GetMapping("/projects/new")
    public String newProject() {return "newproject";}

    @PostMapping("/projects/save")
    public String saveProject(@ModelAttribute("project") Project project, BindingResult result, Model model) {
        if (result.hasErrors()){
            return "error";
        }
        model.addAttribute("project", project);
        ps.saveProject(project);
        return "archived";
    }

    //go to all projects
    @GetMapping("/projects")
    public String projects() {return "projects";}
}