package com.apexon.upskill.test.dto;

import lombok.Data;

@Data
public class TestResultDTO {
    private int totalQuestions;
    private int correctAnswers;
//    private int wrongAnswers;
    private int score;
}
