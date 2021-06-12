package com.example.CaseStudy.dao;

import com.example.CaseStudy.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProjectRepo extends JpaRepository<Project, Long> {
}
