package com.apexon.upskill.util;

import com.apexon.upskill.mcq.dto.OptionCreateDTO;
import com.apexon.upskill.mcq.dto.OptionDTO;
import com.apexon.upskill.mcq.dto.QuestionRequestDTO;
import com.apexon.upskill.mcq.dto.QuestionResponseDTO;
import com.apexon.upskill.mcq.entity.Options;
import com.apexon.upskill.mcq.entity.Question;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class QuestionMapper {
    public static Question toEntity(QuestionRequestDTO dto) {
        Question q = new Question();
        q.setTitle(dto.getTitle());
        q.setSkillId(dto.getSkillId());
        q.setTopicId(dto.getTopicId());
        q.setQuestionLevel(dto.getQuestionLevel());
        q.setSingleChoice(dto.isSingleChoice());

        List<Options> options = new ArrayList<>();
        for (OptionCreateDTO o : dto.getOptions()) {
            Options opt = new Options();
            opt.setTitle(o.getTitle());
            opt.setCorrect(o.isCorrect());
            opt.setQuestion(q);
            options.add(opt);
        }
        q.setOptions(options);
        return q;
    }

    public static QuestionResponseDTO toResponseDTO(Question q) {
        List<OptionDTO> opts = q.getOptions().stream()
                .map(o -> {
                    OptionDTO dto = new OptionDTO();
                    dto.setId(o.getId());
                    dto.setTitle(o.getTitle());
                    dto.setCorrect(o.isCorrect());

                    return dto;
                }).collect(Collectors.toList());
        return new QuestionResponseDTO(q.getId(), q.getTitle(), q.getSkillId(), q.getTopicId(), opts,q.isSingleChoice(),q.getQuestionLevel(),q.getStatus());
    }
}
