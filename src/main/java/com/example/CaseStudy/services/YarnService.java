package com.example.CaseStudy.services;

import com.example.CaseStudy.dao.IYarnRepo;
import com.example.CaseStudy.models.Yarn;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log
@Service
public class YarnService {

    @Autowired
    IYarnRepo repo;
    
    public List<Yarn> getAllYarn() {
        log.info("getAllYarn called");
        return repo.findAll(); };

    public void saveYarn(Yarn yarn) {
        repo.save(yarn);
    };

    public Yarn deleteYarn(Yarn yarn) {
        repo.delete(yarn);
        return yarn;
    };

}
