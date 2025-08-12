package com.apexon.upskill.client;

public class TopicNotFoundException extends RuntimeException{
    public TopicNotFoundException(String message){
        super(message);
    }
}
