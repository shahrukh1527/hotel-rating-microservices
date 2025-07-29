package com.apexon.upskill.mcq.question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @PostMapping("/question")
    public ResponseEntity<String> createQuestion(@RequestBody QuestionRequestDto requestDto){
        questionService.saveQuestion(requestDto);

        return  new ResponseEntity<>("Question created successfully", HttpStatus.CREATED);
    }

    //add update

    // add get api

}
