package com.apexon.upskill.mcq.dto;

import com.apexon.upskill.mcq.entity.QuestionLevel;
import lombok.Data;

import java.util.List;

@Data
public class QuestionRequestDTO {
    private String title;
    private Long skillId;
    private Long topicId;
    private List<OptionCreateDTO> options;
    private QuestionLevel questionLevel;
    private boolean singleChoice;
}
