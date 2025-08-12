package com.apexon.upskill.client;

public class SkillNotFoundException extends RuntimeException{
    public SkillNotFoundException(String message){
        super(message);
    }
}
