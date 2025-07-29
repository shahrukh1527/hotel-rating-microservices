package com.apexon.upskill.mcq.question;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class OptionDto
{
    private String title;

    @JsonProperty("isCorrect")
    private boolean isCorrect;
}
