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
import org.springframework.web.bind.annotation.*;

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

    //delete a project
    @GetMapping("/projects/{id}/delete")
    public String deleteProject(@PathVariable("id") Long id) {

        Project p = ps.getProjectByPId(id);
        log.info("Id: " + id);

        Project deleted = ps.deleteProject(p);

        log.info("deleted " + deleted.toString());

        return "redirect:../projects";
    }

    //view project
    @GetMapping("/projects/{id}")
    public String viewProject(@PathVariable("id") Long id, Model model) {

        Project p = ps.getProjectByPId(id);

        model.addAttribute("project", p);

        return "viewproject";
    }

    //go to edit project page
    @GetMapping("projects/{id}/edit")
    public String editPage(@PathVariable("id") Long id, Model model) {

        Project p = ps.getProjectByPId(id);

        model.addAttribute("project", p);

        return "editProject";
    }

    @PostMapping("projects/update")
    public String editProject(@ModelAttribute("project") Project project, BindingResult result, Model model) {

        ps.saveProject(project);

        return "redirect:../projects";
    }
}