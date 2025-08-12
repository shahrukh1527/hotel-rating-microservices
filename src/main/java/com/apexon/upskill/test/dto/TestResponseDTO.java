package com.apexon.upskill.test.dto;

import lombok.Data;

import java.util.Set;

@Data
public class TestResponseDTO {
    private Long testId;
    private String testName;
    private Set<Long> questionIds;
}
