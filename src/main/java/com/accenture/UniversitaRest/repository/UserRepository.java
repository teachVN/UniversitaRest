package com.accenture.UniversitaRest.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.accenture.UniversitaRest.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    public Optional<User> findByUsername(String username);
}
