package com.apexon.upskill.mcq.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Long skillId;
    private Long topicId;
    @Column(name = "is_single_choice")
    private boolean singleChoice;

    @Enumerated(EnumType.STRING)
    private QuestionStatus status=QuestionStatus.BETA;

    @Enumerated(EnumType.STRING)
    private QuestionLevel questionLevel;


    @OneToMany(mappedBy = "question" , cascade = CascadeType.ALL)
    private List<Options> options=new ArrayList<>();
}
