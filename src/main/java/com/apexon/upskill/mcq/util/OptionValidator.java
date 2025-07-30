package com.apexon.upskill.mcq.util;

import com.apexon.upskill.mcq.dto.OptionCreateDTO;
import com.apexon.upskill.mcq.dto.QuestionRequestDTO;
import com.apexon.upskill.mcq.entity.Options;
import com.apexon.upskill.mcq.entity.Question;

public class OptionValidator {

    public static boolean isValidOption(QuestionRequestDTO dto) {
        return dto.getOptions().stream().anyMatch(OptionCreateDTO::isCorrect);
    }
    public static boolean isValidOption(Question question) {
        return question.getOptions().stream().anyMatch(Options::isCorrect);
    }
}
