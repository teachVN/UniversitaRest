package com.accenture.UniversitaRest.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.Data;

@Data
public class StudenteDto {
    @NotBlank(message = "Il nome non può essere nè nullo nè vuoto nè contenere solo spazi")
    private String nome;
    @NotBlank(message = "Il cognome non può essere nè nullo nè vuoto nè contenere solo spazi")
    private String cognome;
    @NotBlank(message = "La città non può essere nè nulla nè vuota nè contenere solo spazi")
    private String citta;
    @NotNull(message = "La data di nascita non può essere nulla")
    @Past(message = "La data di nascita non può essere nel presente o nel futuro")
    private LocalDate dataNascita;
    
}
