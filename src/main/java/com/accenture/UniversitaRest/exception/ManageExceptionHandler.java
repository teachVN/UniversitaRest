package com.accenture.UniversitaRest.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.accenture.UniversitaRest.model.ApiError;

@RestControllerAdvice
public class ManageExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError badRequestExceptionHandler(BadRequestException e){
        ApiError error = new ApiError();

        error.setMessage(e.getMessage());
        error.setErrorTime(LocalDateTime.now());
        error.setStatus(HttpStatus.BAD_REQUEST);

        return error;
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiError notFoundExceptionHandler(NotFoundException e){
        ApiError error = new ApiError();

        error.setMessage(e.getMessage());
        error.setErrorTime(LocalDateTime.now());
        error.setStatus(HttpStatus.NOT_FOUND);

        return error;
    }

@ExceptionHandler(UnAuthorizedException.class)
@ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ApiError unAutorizedExceptionHandler(UnAuthorizedException e){
        ApiError error = new ApiError();

        error.setMessage(e.getMessage());
        error.setErrorTime(LocalDateTime.now());
        error.setStatus(HttpStatus.UNAUTHORIZED);

        return error;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiError ExceptionHandler(Exception e){
        ApiError error = new ApiError();

        error.setMessage(e.getMessage());
        error.setErrorTime(LocalDateTime.now());
        error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);

        return error;
    }


    
}
