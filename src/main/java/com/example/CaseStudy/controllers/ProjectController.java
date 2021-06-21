package com.example.CaseStudy.controllers;

import com.example.CaseStudy.models.Project;
import com.example.CaseStudy.models.Yarn;
import com.example.CaseStudy.services.ProjectService;
import com.example.CaseStudy.services.YarnService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;

import java.util.List;

@Log
@Controller
public class ProjectController {

    @Autowired
    ProjectService ps;

    @Autowired
    YarnService ys;

    @ModelAttribute("project")
    public Project initProject(){
        return new Project();
    }

    //go to new project
    @GetMapping("/projects/new")
    public String newProject() {return "newproject";}

    @PostMapping("/projects/save")
    public String saveProject(@ModelAttribute("project") Project project, BindingResult result, Model model) {

        List<Yarn> yarnList = ys.getAllYarn();
        model.addAttribute("yarnList", yarnList);

        if (result.hasErrors()) {
            log.warning("Invalid input");
            return "newproject";
        }

        model.addAttribute("project", project);
        ps.saveProject(project);
        return "redirect:../projects";
    }

    //go to all projects
    @GetMapping("/projects")
    public String projects(Model model) {
        List<Project> projects = ps.getAllProjects();
        model.addAttribute("projects", projects);
        return "projects";}
}