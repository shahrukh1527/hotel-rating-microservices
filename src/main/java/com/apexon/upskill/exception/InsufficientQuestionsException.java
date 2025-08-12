package com.apexon.upskill.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class InsufficientQuestionsException extends RuntimeException{
     public InsufficientQuestionsException(String message){
         super(message);
     }
}
