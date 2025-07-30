package com.apexon.upskill.mcq.service;

import com.apexon.upskill.mcq.dto.QuestionRequestDTO;
import com.apexon.upskill.mcq.dto.QuestionResponseDTO;
import com.apexon.upskill.mcq.dto.QuestionUpdateDTO;
import com.apexon.upskill.mcq.entity.QuestionStatus;

import java.util.List;

public interface QuestionService {
    QuestionResponseDTO saveQuestion(QuestionRequestDTO dto);
    List<QuestionResponseDTO> getAllQuestions();
    QuestionResponseDTO updateQuestion(Long qstnId, QuestionUpdateDTO dto);

    QuestionResponseDTO updateQuestionStatus(Long id , QuestionStatus status);
}
