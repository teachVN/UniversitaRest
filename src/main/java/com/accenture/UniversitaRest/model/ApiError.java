package com.accenture.UniversitaRest.model;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ApiError {

    private String message;
    private LocalDateTime errorTime;

    private HttpStatus status;
    
}
