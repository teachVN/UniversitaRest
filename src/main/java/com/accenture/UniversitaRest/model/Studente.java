package com.accenture.UniversitaRest.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "studenti")
public class Studente {

    @Id
    @GeneratedValue
    private Integer matricola;

    private String nome;
    private String cognome;
    private String citta;
    private LocalDate dataNascita;

}
