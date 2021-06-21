package com.example.CaseStudy.services;

import com.example.CaseStudy.dao.IProjectRepo;
import com.example.CaseStudy.models.Project;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log
@Service
public class ProjectService {

    @Autowired
    IProjectRepo repo;

    public List<Project> getAllProjects() {
        return repo.findAll();
    }

    public List<Project> getProjectsByUserId(Long uId) {
        return repo.findByuId(uId);
    }

    public void saveProject(Project p) {
        repo.save(p);
        log.info("project saved");
    }

    public Project deleteProject(Project p){
        repo.delete(p);
        return p;
    }
}
