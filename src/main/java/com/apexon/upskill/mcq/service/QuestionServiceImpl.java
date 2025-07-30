package com.apexon.upskill.mcq.service;

import com.apexon.upskill.mcq.dto.OptionDTO;
import com.apexon.upskill.mcq.dto.QuestionRequestDTO;
import com.apexon.upskill.mcq.dto.QuestionResponseDTO;
import com.apexon.upskill.mcq.dto.QuestionUpdateDTO;
import com.apexon.upskill.mcq.entity.Options;
import com.apexon.upskill.mcq.entity.Question;
import com.apexon.upskill.mcq.entity.QuestionStatus;
import com.apexon.upskill.mcq.exception.InvalidOptionException;
import com.apexon.upskill.mcq.exception.ResourceNotFoundException;
import com.apexon.upskill.mcq.repository.OptionRepository;
import com.apexon.upskill.mcq.repository.QuestionRepository;
import com.apexon.upskill.mcq.util.OptionValidator;
import com.apexon.upskill.mcq.util.QuestionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private OptionRepository optionRepository;

    @Override
    public QuestionResponseDTO saveQuestion(QuestionRequestDTO dto)  {
        boolean isValid = OptionValidator.isValidOption(dto);

        if (!isValid) {
            throw new InvalidOptionException("At least one option must be marked as correct.");
        }
        Question question = QuestionMapper.toEntity(dto);
        return QuestionMapper.toResponseDTO(questionRepository.save(question));
    }

    @Override
    public List<QuestionResponseDTO> getAllQuestions() {
        return questionRepository.findAll().stream()
                .map(QuestionMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public QuestionResponseDTO updateQuestion(Long qstnId, QuestionUpdateDTO dto) {
        Question question = questionRepository.findById(qstnId)
                .orElseThrow(() -> new ResourceNotFoundException("Question not found with ID: " + qstnId));

        question.setTitle(dto.getTitle());
        question.setSkillId(dto.getSkillId());
        question.setTopicId(dto.getTopicId());
        question.setQuestionLevel(dto.getQuestionLevel());

        List<Options> updatedOptions = new ArrayList<>();
        for(OptionDTO opt:dto.getOptions()){
            if(opt.getId()!=null){
                Options existingOption = optionRepository.findById(opt.getId())
                        .orElseThrow(()->new ResourceNotFoundException("Option not found with ID: "+opt.getId()));
                existingOption.setTitle(opt.getTitle());
                existingOption.setCorrect(opt.isCorrect());
                updatedOptions.add(existingOption);
            }else{
                Options newOption = new Options();
                newOption.setTitle(opt.getTitle());
                newOption.setCorrect(opt.isCorrect());
                newOption.setQuestion(question);
                updatedOptions.add(newOption);
            }
        }
//        question.getOptions().clear();
        question.getOptions().addAll(updatedOptions);

        boolean isValid=OptionValidator.isValidOption(question);
        if(!isValid){
            throw new InvalidOptionException("Atlest one option must be correct");
        }

        Question savedQstn = questionRepository.save(question);
        return QuestionMapper.toResponseDTO(savedQstn);
    }

    @Override
    public QuestionResponseDTO updateQuestionStatus(Long qstnId, QuestionStatus status) {
        Question question = questionRepository.findById(qstnId)
                .orElseThrow(() -> new ResourceNotFoundException("Question not found with ID: " + qstnId));
        question.setStatus(status);
        Question saved = questionRepository.save(question);
        return QuestionMapper.toResponseDTO(saved);

    }
}
