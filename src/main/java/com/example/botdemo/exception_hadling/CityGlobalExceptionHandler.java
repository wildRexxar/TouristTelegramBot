package com.example.botdemo.exception_hadling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CityGlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<CityIncorrectData> handleException(
            CityException exception){
        CityIncorrectData data = new CityIncorrectData();
        data.setInfo(exception.getMessage());

        return  new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<CityIncorrectData> handleException(
            Exception exception){
        CityIncorrectData data = new CityIncorrectData();
        data.setInfo(exception.getMessage());

        return  new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }
}
