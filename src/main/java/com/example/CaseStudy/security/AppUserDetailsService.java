package com.example.CaseStudy.security;

import com.example.CaseStudy.dao.IUserRepo;
import com.example.CaseStudy.models.User;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@Log
public class AppUserDetailsService implements UserDetailsService {

    @Autowired
    IUserRepo iUserRepo;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<User> user = iUserRepo.findByUsername(s);
        if(user.isEmpty()){
            throw new UsernameNotFoundException("User not found");
        }

        return new AppUserDetails(user.get());
    }
}
