package com.accenture.UniversitaRest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.stereotype.Service;

import com.accenture.UniversitaRest.model.Studente;
import com.accenture.UniversitaRest.repository.StudenteRepository;

@Service
public class StudenteService {

    @Autowired
    private StudenteRepository studenteRepository;

    public Studente save(Studente studente){
        return studenteRepository.save(studente);
    }

    public Studente update(Integer matricola, Studente studente){
        Studente studenteDaAggiornare = studenteRepository.findById(matricola).get();

        studenteDaAggiornare.setNome(studente.getNome());
        studenteDaAggiornare.setCognome(studente.getCognome());
        studenteDaAggiornare.setCitta(studente.getCitta());
        studenteDaAggiornare.setDataNascita(studente.getDataNascita());

        return studenteRepository.save(studenteDaAggiornare);
    }

    public void delete(Integer matricola){
        
        studenteRepository.deleteById(matricola);
    }

    public Studente getByMatricola(Integer matricola){
        return studenteRepository.findById(matricola).get();
    }

    public List<Studente> getAll(){
        return studenteRepository.findAll();
    }
    
}
