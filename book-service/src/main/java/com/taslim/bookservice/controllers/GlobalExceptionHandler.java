package com.taslim.bookservice.controllers;

import com.taslim.bookservice.exception.BookNameAuthorNameAlreadyExistsExcepion;
import com.taslim.bookservice.model.ExceptionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({BookNameAuthorNameAlreadyExistsExcepion.class})
    public ResponseEntity<Object> returnNotFoundException(Exception ex ){


         if (ex instanceof BookNameAuthorNameAlreadyExistsExcepion){
            return new ResponseEntity<>( new ExceptionModel(ex.getMessage()) , HttpStatus.BAD_REQUEST);

        }
        else {
            return new ResponseEntity<>( new ExceptionModel(ex.getMessage()) , HttpStatus.NOT_IMPLEMENTED);

        }

    }
}

