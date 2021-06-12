package com.example.CaseStudy.dao;

import com.example.CaseStudy.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepo extends JpaRepository<User, Long> {
}