package com.accenture.UniversitaRest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accenture.UniversitaRest.model.Studente;

public interface StudenteRepository extends JpaRepository<Studente, Integer>{
    
}
