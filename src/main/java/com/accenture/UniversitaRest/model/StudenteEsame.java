package com.accenture.UniversitaRest.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "studenti_esami")
public class StudenteEsame {

    @Id
    @GeneratedValue
    private Integer id;
    
    private LocalDate dataEsame;
    private int voto;

    @ManyToOne
    @JoinColumn(name = "studente_fk")
    private Studente studente;


    @ManyToOne
    @JoinColumn(name = "esame_fk")
    private Esame esame;
}
