package com.wendyam_rayaisse.patient.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class PatientAlreadyExistsException extends RuntimeException{

    public PatientAlreadyExistsException(String message){
        super(message);
    }
}
