package com.example.CaseStudy.services;

import com.example.CaseStudy.dao.IUserRepo;
import com.example.CaseStudy.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    IUserRepo repo;

    public void saveUser(User u) {
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
