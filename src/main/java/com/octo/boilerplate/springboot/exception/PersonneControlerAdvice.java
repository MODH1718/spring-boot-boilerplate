package com.octo.boilerplate.springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class PersonneControlerAdvice {
    @org.springframework.web.bind.annotation.ExceptionHandler({PersonneNotFound.class})
    public ResponseEntity<ApiErreur> personneNotFound(PersonneNotFound ex) {
        return new ResponseEntity<>(new ApiErreur(400, ex.getMessage()),
                HttpStatus.NOT_FOUND);

    }


}
