package com.apexon.upskill.test.service;

import com.apexon.upskill.exception.InsufficientQuestionsException;
import com.apexon.upskill.exception.TemplateNotFoundException;
import com.apexon.upskill.template.entity.Template;
import com.apexon.upskill.template.entity.TemplateTopicQuestionCount;
import com.apexon.upskill.template.repository.TemplateRepository;
import com.apexon.upskill.test.dto.*;
import com.apexon.upskill.test.entity.Assessment;
import com.apexon.upskill.test.repository.AssessmentRepository;
import com.apexon.upskill.mcq.entity.Options;
import com.apexon.upskill.mcq.entity.Question;
import com.apexon.upskill.mcq.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AssessmentServiceImpl implements AssessmentService{

    @Autowired
    private  QuestionRepository questionRepository;

    @Autowired
    private AssessmentRepository assessmentRepository;

    @Autowired
    private TemplateRepository templateRepository;

    @Override
    public TestResponseDTO createTest(TestRequestDTO requestDTO) {

        Template template = templateRepository.findById(requestDTO.getTemplateId())
                .orElseThrow(() -> new TemplateNotFoundException("Template ID " + requestDTO.getTemplateId() + " not found."));

        Set<Question> selectedQuestions = new HashSet<>();

        // Fetch questions as per the template topic + count mapping
        for (TemplateTopicQuestionCount countInfo : template.getTopicQuestionCounts()) {
            Long topicId = countInfo.getTopicId();
            int count = countInfo.getCount();

            // Get random 'count' number of questions from the topic
            List<Question> questions = questionRepository.findRandomQuestionsByTopicId(topicId, count);

            if (questions.size() < count) {
                throw new InsufficientQuestionsException(
                        "Not enough questions for topic ID " + topicId + ". Required: " + count + ", Found: " + questions.size()
                );
            }
            selectedQuestions.addAll(questions);
        }

        Assessment assessment = new Assessment();
        assessment.setAssessmentName(requestDTO.getTestName());
        assessment.setQuestions(selectedQuestions);

        Assessment saved = assessmentRepository.save(assessment);

        TestResponseDTO dto = new TestResponseDTO();
        dto.setTestId(saved.getId());
        dto.setTestName(saved.getAssessmentName());
        dto.setQuestionIds(
                selectedQuestions.stream().map(Question::getId).collect(Collectors.toSet())
        );

        return dto;
    }

    @Override
    public TestResultDTO evaluateAnswers(TestSubmitDTO testSubmitDTO) {
        int total = testSubmitDTO.getAnswers().size();
        int correctCount = 0;

        for (QuestionAnswerDTO answer : testSubmitDTO.getAnswers()) {
            Optional<Question> questionOpt = questionRepository.findById(answer.getQuestionId());
            if (answer.getSelectedOptionIds() == null || answer.getSelectedOptionIds().isEmpty()) continue;
            Question q = questionOpt.get();

            Set<Long> correctOptionIds = q.getOptions().stream()
                    .filter(Options::isCorrect)
                    .map(Options::getId)
                    .collect(Collectors.toSet());

            Set<Long> selectedOptionIds = new HashSet<>(answer.getSelectedOptionIds());

            // Check if selected options exactly match correct options
            if (selectedOptionIds.equals(correctOptionIds)) {
                correctCount++;
            }
        }

        TestResultDTO result = new TestResultDTO();
        result.setTotalQuestions(total);
        result.setCorrectAnswers(correctCount);
//        result.setWrongAnswers(total-correctCount);
        result.setScore((correctCount * 100) / total); // % score

        return result;
    }

}
