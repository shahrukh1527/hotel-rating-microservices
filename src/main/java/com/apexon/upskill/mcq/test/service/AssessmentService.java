package com.apexon.upskill.mcq.test.service;

import com.apexon.upskill.mcq.test.dto.TestRequestDTO;
import com.apexon.upskill.mcq.test.dto.TestResponseDTO;
import com.apexon.upskill.mcq.test.dto.TestSubmitDTO;
import com.apexon.upskill.mcq.test.dto.TestResultDTO;

public interface AssessmentService {

    TestResponseDTO createTest(TestRequestDTO testRequestDTO);

    TestResultDTO evaluateAnswers(TestSubmitDTO testSubmitDTO);


}
