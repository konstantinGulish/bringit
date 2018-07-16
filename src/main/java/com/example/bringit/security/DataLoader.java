package com.example.bringit.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    AppUserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... strings) throws Exception {

        Role aRole = new Role();
        aRole.setRole("BUYER");
        roleRepository.save(aRole);

        aRole = new Role();
        aRole.setRole("SELLER");
        roleRepository.save(aRole);

        AppUser user = new AppUser();
        user.setPassword("password");
        user.setUsername("buyer");
        user.addRole(roleRepository.findByRole("BUYER"));
        userRepository.save(user);

        user = new AppUser();
        user.setUsername("seller");
        user.setPassword("password");
        user.addRole(roleRepository.findByRole("SELLER"));
        userRepository.save(user);
    }

}
