package com.apexon.upskill.test.controller;

import com.apexon.upskill.test.dto.TestRequestDTO;
import com.apexon.upskill.test.dto.TestResponseDTO;
import com.apexon.upskill.test.dto.TestSubmitDTO;
import com.apexon.upskill.test.dto.TestResultDTO;
import com.apexon.upskill.test.service.AssessmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private AssessmentService assessmentService;

    @PostMapping("/create")
    public ResponseEntity<TestResponseDTO> create(@RequestBody TestRequestDTO dto){
        return new ResponseEntity<>(assessmentService.createTest(dto), HttpStatus.CREATED);
    }

    @GetMapping("/evaluate")
    public TestResultDTO evaluateTest(@RequestBody TestSubmitDTO testSubmitDTO) {
        return assessmentService.evaluateAnswers(testSubmitDTO);
    }
}
