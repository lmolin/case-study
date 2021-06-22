package com.example.CaseStudy.services;

import com.example.CaseStudy.dao.IUserRepo;
import com.example.CaseStudy.models.User;

import com.example.CaseStudy.security.AppSecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    IUserRepo repo;

    public void saveUser(User u) {

        u.setPassword(AppSecurityConfig.getPasswordEncoder().encode(u.getPassword()));
        repo.save(u);
    }

    public User deleteUser(User u) {
        repo.delete(u);
        return u;
    }

    public List<User> getAllUsers() {
        return repo.findAll();
    }
}
