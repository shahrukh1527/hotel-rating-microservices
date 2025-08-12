package com.apexon.upskill.mcq.test.dto;

import lombok.Data;

import java.util.List;

@Data
public class QuestionAnswerDTO {
    private Long questionId;
    private List<Long> selectedOptionIds;
}
