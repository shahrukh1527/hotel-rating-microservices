package com.apexon.upskill.mcq.controller;

import com.apexon.upskill.mcq.dto.QuestionRequestDTO;
import com.apexon.upskill.mcq.dto.QuestionResponseDTO;
import com.apexon.upskill.mcq.dto.QuestionUpdateDTO;
import com.apexon.upskill.mcq.entity.QuestionStatus;
import com.apexon.upskill.mcq.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @PostMapping()
    public ResponseEntity<QuestionResponseDTO> create(@RequestBody QuestionRequestDTO dto){
        return new ResponseEntity<>(questionService.saveQuestion(dto), HttpStatus.CREATED);
    }

    @GetMapping
    public List<QuestionResponseDTO> getAll(){
        return  questionService.getAllQuestions();
    }

    @PutMapping("/{id}")
    public QuestionResponseDTO update(@PathVariable Long id , @RequestBody QuestionUpdateDTO dto){
        return questionService.updateQuestion(id,dto);
    }

    @PatchMapping("/updateStatus/{id}")
    public ResponseEntity<QuestionResponseDTO> updateQuestionStatus(@PathVariable Long id , @RequestParam QuestionStatus status){
        return new ResponseEntity<>(questionService.updateQuestionStatus(id,status), HttpStatus.CREATED);
    }

}
