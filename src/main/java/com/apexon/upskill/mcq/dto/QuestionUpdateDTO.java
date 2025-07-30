package com.apexon.upskill.mcq.dto;

import com.apexon.upskill.mcq.entity.QuestionLevel;
import lombok.Data;

import java.util.List;

@Data
public class QuestionUpdateDTO {
    private String title;
    private Long skillId;
    private Long topicId;
    private List<OptionDTO> options;
    private boolean singleChoice;
    private QuestionLevel questionLevel;
}
