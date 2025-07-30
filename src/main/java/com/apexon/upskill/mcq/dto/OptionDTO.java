package com.apexon.upskill.mcq.dto;

import lombok.Data;

@Data
public class OptionDTO {
    private Long id;
    private String title;
    private boolean correct;
}
