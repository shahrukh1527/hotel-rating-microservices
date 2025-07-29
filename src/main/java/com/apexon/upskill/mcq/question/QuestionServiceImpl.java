package com.apexon.upskill.mcq.question;

import com.apexon.upskill.mcq.topic.TopicServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService{

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private OptionRepository optionRepository;

    @Autowired
    private TopicServiceClient topicServiceClient;

    @Override
    public void saveQuestion(QuestionRequestDto dto) {
       topicServiceClient.validateTopic(dto.getTopicId(),dto.getSkillId());
        boolean hasCorrectMatch = dto.getOptions().stream().anyMatch(OptionDto::isCorrect);
        if(!hasCorrectMatch){
            throw new InvalidOptionException("Atlest one option must be correct");
        }

        Question question = new Question();
        question.setTitle(dto.getTitle());
        question.setSkillId(dto.getSkillId());
        question.setTopicId(dto.getTopicId());

        Question saved = questionRepository.save(question);

        List<Options> options = dto.getOptions().stream().map(opt->{
            Options o= new Options();
            o.setTitle(opt.getTitle());
            o.setCorrect(opt.isCorrect());
            o.setQuestion(saved);

            optionRepository.save(o);
            return o;
        }).toList();


    }
}
