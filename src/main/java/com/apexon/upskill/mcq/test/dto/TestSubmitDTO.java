package com.apexon.upskill.mcq.test.dto;

import lombok.Data;

import java.util.List;

@Data
public class TestSubmitDTO {
    private List<QuestionAnswerDTO> answers;
}
