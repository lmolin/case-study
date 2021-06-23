package com.example.CaseStudy.dao;

import com.example.CaseStudy.models.Yarn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IYarnRepo extends JpaRepository<Yarn, Long> {

}
