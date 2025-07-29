package com.apexon.upskill.mcq.question;

import lombok.Data;

import java.util.List;

@Data
public class QuestionRequestDto
{
    private String title;
    private Long skillId;
    private Long topicId;
    private List<OptionDto> options;
}
