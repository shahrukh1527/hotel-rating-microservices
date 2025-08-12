package com.apexon.upskill.test.service;

import com.apexon.upskill.test.dto.TestRequestDTO;
import com.apexon.upskill.test.dto.TestResponseDTO;
import com.apexon.upskill.test.dto.TestSubmitDTO;
import com.apexon.upskill.test.dto.TestResultDTO;

public interface AssessmentService {

    TestResponseDTO createTest(TestRequestDTO testRequestDTO);

    TestResultDTO evaluateAnswers(TestSubmitDTO testSubmitDTO);


}
