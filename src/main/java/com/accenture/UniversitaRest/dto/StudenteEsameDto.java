package com.accenture.UniversitaRest.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class StudenteEsameDto {

    private LocalDate dataEsame;
    private int voto;
    private int studente_id;
    private int esame_id;
    
}
