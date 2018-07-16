package com.example.bringit.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.util.Arrays;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    AppUserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    public UserService(AppUserRepository userRepository){
        this.userRepository = userRepository;
    }

    public AppUser findByUsername(String username){
        return userRepository.findByUsername(username);
    }

    public void saveUser (AppUser user){
        user.addRole(roleRepository.findByRole("BUYER"));
        user.addRole(roleRepository.findByRole("SELLER"));
        user.setEnabled(true);
        userRepository.save (user);
    }
}
