package com.apexon.upskill.test.dto;

import lombok.Data;

import java.util.List;

@Data
public class TestSubmitDTO {
    private List<QuestionAnswerDTO> answers;
}
