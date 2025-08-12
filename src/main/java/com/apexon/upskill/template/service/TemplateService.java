package com.apexon.upskill.template.service;

import com.apexon.upskill.template.dto.TemplateRequestDTO;
import com.apexon.upskill.template.dto.TemplateResponseDTO;

import java.util.List;

public interface TemplateService {
    TemplateResponseDTO createTemplate(TemplateRequestDTO dto);

    List<TemplateResponseDTO> getAllTemplates();
}
