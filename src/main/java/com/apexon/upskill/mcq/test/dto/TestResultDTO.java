package com.apexon.upskill.mcq.test.dto;

import lombok.Data;

@Data
public class TestResultDTO {
    private int totalQuestions;
    private int correctAnswers;
//    private int wrongAnswers;
    private int score;
}
