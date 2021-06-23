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
    public String newProject(Model model) {

        List<Yarn> yarnList = ys.getAllYarn();
        model.addAttribute("yarnList", yarnList);

        return "newproject";
    }

    @PostMapping("/projects/save")
    public String saveProject(@RequestParam("pName") String name,
                              @RequestParam("pYarn") List<Yarn> yarn,
                              @RequestParam("pDesc") String pDesc,
                              Model model) {

        Project p = new Project();
        p.setPName(name);
        p.setPYarn(yarn);
        p.setPDesc(pDesc);

        ps.saveProject(p);

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

        List<Yarn> yarnList = ys.getAllYarn();
        model.addAttribute("yarnList", yarnList);

        Project p = ps.getProjectByPId(id);
        model.addAttribute("project", p);

        return "editProject";
    }

    @PostMapping("projects/update")
    public String editProject(@RequestParam("pName") String name,
                              @RequestParam("pYarn") List<Yarn> yarn,
                              @RequestParam("pDesc") String pDesc,
                              @RequestParam("pId") Long pId,
                              Model model) {

        Project p = ps.getProjectByPId(pId);

        p.setPName(name);
        p.setPYarn(yarn);
        p.setPDesc(pDesc);

        ps.saveProject(p);

        return "redirect:../projects";
    }
}