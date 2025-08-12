package com.apexon.upskill.mcq.client;

public class SkillNotFoundException extends RuntimeException{
    public SkillNotFoundException(String message){
        super(message);
    }
}
