package com.accenture.UniversitaRest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.accenture.UniversitaRest.enumeration.Role;
import com.accenture.UniversitaRest.model.User;
import com.accenture.UniversitaRest.repository.UserRepository;

@Component
public class AdminRunner implements CommandLineRunner{

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User admin = new User();

        admin.setNome("admin");
        admin.setCognome("admin");
        admin.setUsername("admin");
        admin.setPassword(passwordEncoder.encode("admin"));
        admin.setRole(Role.ADMIN);

        //userRepository.save(admin);

    }

    
    
}
