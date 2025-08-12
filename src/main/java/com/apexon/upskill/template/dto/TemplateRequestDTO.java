package com.apexon.upskill.template.dto;

import lombok.Data;

import java.util.List;

@Data
public class TemplateRequestDTO {
   private String templateName;
   private Long skillId;
   private List<TopicQuestionCountsDTO> topicQuestionCounts;

}
