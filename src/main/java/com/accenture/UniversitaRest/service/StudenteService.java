package com.accenture.UniversitaRest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.stereotype.Service;

import com.accenture.UniversitaRest.dto.StudenteDto;
import com.accenture.UniversitaRest.exception.NotFoundException;
import com.accenture.UniversitaRest.model.Studente;
import com.accenture.UniversitaRest.repository.StudenteRepository;

@Service
public class StudenteService {

    @Autowired
    private StudenteRepository studenteRepository;

    public Studente save(StudenteDto studenteDto){
        //questo metodo converte il dto nell'entità che andrà salvata nel db
        Studente studente = dtoToEntity(studenteDto);

        System.out.println(studente);

        return studenteRepository.save(studente);
    }

    public Studente update(Integer matricola, StudenteDto studenteDto){
        Studente studenteDaAggiornare = studenteRepository.findById(matricola).orElseThrow(()->new NotFoundException("Studente con matricola " + matricola + " non trovata"));

        Studente studente = dtoToEntity(studenteDto);

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
        return studenteRepository.findById(matricola).orElseThrow(()->new NotFoundException("Studente con matricola " + matricola + " non trovata"));
    }

    public List<Studente> getAll(){
        return studenteRepository.findAll();
    }

    private Studente dtoToEntity(StudenteDto studenteDto){
        Studente studente = new Studente();

        studente.setNome(studenteDto.getNome());
        studente.setCognome(studenteDto.getCognome());
        studente.setCitta(studenteDto.getCitta());
        studente.setDataNascita(studenteDto.getDataNascita());

        return studente;
    }
    
}
