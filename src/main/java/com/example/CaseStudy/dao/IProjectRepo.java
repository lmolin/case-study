package com.example.CaseStudy.dao;

import com.example.CaseStudy.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProjectRepo extends JpaRepository<Project, Long> {

    List<Project> findByUId(Long uId);
}
