package com.example.CaseStudy.services;

import com.example.CaseStudy.dao.IProjectRepo;
import com.example.CaseStudy.models.Project;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProjectService {

    @Autowired
    IProjectRepo repo;

    public List<Project> getAllProjects() {
        return repo.findAll();
    }

    public List<Project> getProjectsByUserId(Long uId) {
        return repo.findByUId(uId);
    }

    public void saveProject(Project p) {
        repo.save(p);
    }

    public Project deleteProject(Project p){
        repo.delete(p);
        return p;
    }
}
