package com.apexon.upskill.mcq.template.util;

import com.apexon.upskill.mcq.dto.OptionCreateDTO;
import com.apexon.upskill.mcq.dto.OptionDTO;
import com.apexon.upskill.mcq.dto.QuestionRequestDTO;
import com.apexon.upskill.mcq.dto.QuestionResponseDTO;
import com.apexon.upskill.mcq.entity.Options;
import com.apexon.upskill.mcq.entity.Question;
import com.apexon.upskill.mcq.template.dto.TemplateRequestDTO;
import com.apexon.upskill.mcq.template.dto.TemplateResponseDTO;
import com.apexon.upskill.mcq.template.dto.TopicQuestionCountsDTO;
import com.apexon.upskill.mcq.template.entity.Template;
import com.apexon.upskill.mcq.template.entity.TemplateTopicQuestionCount;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TemplateMapper {
    public static Template toEntity(TemplateRequestDTO dto) {
        Template template = new Template();
        template.setTemplateName(dto.getTemplateName());
        template.setSkillId(dto.getSkillId());

        List<TemplateTopicQuestionCount> counts = new ArrayList<>();
        for (TopicQuestionCountsDTO o : dto.getTopicQuestionCounts()) {
            TemplateTopicQuestionCount count = new TemplateTopicQuestionCount();
            count.setCount(o.getCount());
            count.setTopicId(o.getTopicId());
            count.setTemplate(template);

            counts.add(count);
        }
        template.setTopicQuestionCounts(counts);
        return template;
    }

    public static TemplateResponseDTO toResponseDTO(Template template) {
        List<TopicQuestionCountsDTO> opts = template.getTopicQuestionCounts().stream()
                .map(o -> {
                    TopicQuestionCountsDTO dto = new TopicQuestionCountsDTO();
                    dto.setCount(o.getCount());
                    dto.setTopicId(o.getTopicId());
                    return dto;
                }).collect(Collectors.toList());
        return new TemplateResponseDTO(template.getId(), template.getTemplateName(), opts);
    }
}
