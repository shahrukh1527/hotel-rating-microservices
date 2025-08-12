package com.apexon.upskill.mcq.template.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TemplateResponseDTO {
    private Integer templateId;
    private String templateName;
    private List<TopicQuestionCountsDTO> topicQuestionCountsDTO;
}
