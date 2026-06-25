package com.accenture.UniversitaRest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.UniversitaRest.dto.EsameDto;
import com.accenture.UniversitaRest.dto.StudenteDto;
import com.accenture.UniversitaRest.model.Esame;
import com.accenture.UniversitaRest.model.Studente;
import com.accenture.UniversitaRest.repository.EsameRepository;
import com.accenture.UniversitaRest.repository.StudenteRepository;

@Service
public class EsameService {

    @Autowired
    private EsameRepository esameRepository;

    public Esame save(EsameDto esameDto){
        //questo metodo converte il dto nell'entità che andrà salvata nel db
        Esame esame = dtoToEntity(esameDto);

        return esameRepository.save(esame);
    }

    public Esame update(Integer id, EsameDto esameDto){
        Esame esameDaAggiornare = esameRepository.findById(id).get();

        Esame esame = dtoToEntity(esameDto);

        esameDaAggiornare.setNome(esame.getNome());
        esameDaAggiornare.setAula(esame.getAula());;
       

        return esameRepository.save(esameDaAggiornare);
    }

    public void delete(Integer id){
        
        esameRepository.deleteById(id);
    }

    public Esame getById(Integer id){
        return esameRepository.findById(id).get();
    }

    public List<Esame> getAll(){
        return esameRepository.findAll();
    }

    private Esame dtoToEntity(EsameDto esameDto){
        Esame esame = new Esame();

        esame.setNome(esameDto.getNome());
        esame.setAula(esameDto.getAula());
        
        return esame;
    }
    
}
