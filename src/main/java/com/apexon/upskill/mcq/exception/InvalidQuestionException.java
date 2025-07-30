package com.apexon.upskill.mcq.exception;

public class InvalidQuestionException extends RuntimeException {
    public InvalidQuestionException(String s) {
        super((s));
    }
}
