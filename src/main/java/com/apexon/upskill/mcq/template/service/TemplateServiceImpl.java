package com.apexon.upskill.mcq.template.service;

import com.apexon.upskill.mcq.entity.Question;
import com.apexon.upskill.mcq.template.dto.TemplateRequestDTO;
import com.apexon.upskill.mcq.template.dto.TemplateResponseDTO;
import com.apexon.upskill.mcq.template.entity.Template;
import com.apexon.upskill.mcq.template.repository.TemplateRepository;
import com.apexon.upskill.mcq.template.util.TemplateMapper;
import com.apexon.upskill.mcq.util.QuestionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TemplateServiceImpl implements  TemplateService{

    @Autowired
    private TemplateRepository templateRepository;

    @Override
    public TemplateResponseDTO createTemplate(TemplateRequestDTO dto) {
        Template template  = TemplateMapper.toEntity(dto);
        return TemplateMapper.toResponseDTO(templateRepository.save(template));
    }

    @Override
    public List<TemplateResponseDTO> getAllTemplates() {
        List<Template> templates = templateRepository.findAll();

        return templates.stream()
                .map(TemplateMapper::toResponseDTO) // assuming toResponseDTO is in the same service class
                .collect(Collectors.toList());
    }


}
