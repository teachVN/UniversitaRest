package com.accenture.UniversitaRest.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "esami")
public class Esame {
    @Id
    @GeneratedValue
    private Integer id;

    private String nome;
    private String aula;
   
    @OneToMany(mappedBy = "esame")
    private List<StudenteEsame> studentiEsami;
    
}
