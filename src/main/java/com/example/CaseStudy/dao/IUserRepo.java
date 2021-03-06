package com.example.CaseStudy.dao;

import com.example.CaseStudy.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepo extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String u);
}