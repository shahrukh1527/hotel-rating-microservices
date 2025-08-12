package com.apexon.upskill.mcq.template.controller;

import com.apexon.upskill.mcq.template.dto.TemplateRequestDTO;
import com.apexon.upskill.mcq.template.dto.TemplateResponseDTO;
import com.apexon.upskill.mcq.template.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/template")
public class TemplateController {

    @Autowired
    private TemplateService templateService;

    @PostMapping()
    public ResponseEntity<TemplateResponseDTO> create(@RequestBody TemplateRequestDTO dto){
        return new ResponseEntity<>(templateService.createTemplate(dto), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<TemplateResponseDTO>> getAllTemplates(){
        return new ResponseEntity<>(templateService.getAllTemplates(), HttpStatus.OK);
    }
}
