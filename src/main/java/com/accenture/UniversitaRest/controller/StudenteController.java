package com.accenture.UniversitaRest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.UniversitaRest.model.Studente;
import com.accenture.UniversitaRest.service.StudenteService;

@RestController
public class StudenteController {

    @Autowired
    private StudenteService studenteService;

    @PostMapping("/studenti")
    public Studente save(@RequestBody Studente studente){
        return studenteService.save(studente);
    }

    @PutMapping("/studenti/{matricola}")
    public Studente update(@PathVariable Integer matricola, @RequestBody Studente studente){
        return studenteService.update(matricola, studente);
    }

    @DeleteMapping("/studenti/{matricola}")
    public void delete(@PathVariable Integer matricola){
        studenteService.delete(matricola);
    }

    @GetMapping("/studenti/{matricola}")
    public Studente getByMatricola(@PathVariable Integer matricola){
        return studenteService.getByMatricola(matricola);
    }

    @GetMapping("/studenti")
    public List<Studente> getAll(){
        return studenteService.getAll();
    }
    
}
