package com.apexon.upskill.mcq.template.service;

import com.apexon.upskill.mcq.template.dto.TemplateRequestDTO;
import com.apexon.upskill.mcq.template.dto.TemplateResponseDTO;

import java.util.List;

public interface TemplateService {
    TemplateResponseDTO createTemplate(TemplateRequestDTO dto);

    List<TemplateResponseDTO> getAllTemplates();
}
