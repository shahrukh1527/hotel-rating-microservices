package com.apexon.upskill.mcq.dto;

import com.apexon.upskill.mcq.entity.QuestionLevel;
import com.apexon.upskill.mcq.entity.QuestionStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionResponseDTO {
    private long id;
    private String title;
    private Long skillId;
    private Long topicId;
    private List<OptionDTO> options;
    private boolean singleChoice;
    private QuestionLevel questionLevel;
    private QuestionStatus status;

}
