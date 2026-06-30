package com.accenture.UniversitaRest.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.UniversitaRest.dto.EsameDto;
import com.accenture.UniversitaRest.dto.StudenteDto;
import com.accenture.UniversitaRest.exception.BadRequestException;
import com.accenture.UniversitaRest.model.Esame;
import com.accenture.UniversitaRest.model.Studente;
import com.accenture.UniversitaRest.service.EsameService;
import com.accenture.UniversitaRest.service.StudenteService;

@RestController
public class EsameController {

    @Autowired
    private EsameService esameService;

    @PostMapping("/esami")
    public Esame save(@RequestBody @Validated EsameDto esameDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            
            throw new BadRequestException(bindingResult.getAllErrors().stream().map(e->e.getDefaultMessage()).collect(Collectors.joining(", ")));
        }

        return esameService.save(esameDto);
    }

    @PutMapping("/esami/{id}")
    public Esame update(@PathVariable Integer id, @RequestBody @Validated EsameDto esameDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            
            throw new BadRequestException(bindingResult.getAllErrors().stream().map(e->e.getDefaultMessage()).collect(Collectors.joining(", ")));
        }

        return esameService.update(id, esameDto);
    }

    @DeleteMapping("/esami/{id}")
    public void delete(@PathVariable Integer id){
        esameService.delete(id);
    }

    @GetMapping("/esami/{id}")
    public Esame getById(@PathVariable Integer id){
        return esameService.getById(id);
    }

    @GetMapping("/esami")
    public List<Esame> getAll(){
        return esameService.getAll();
    }
    
}
