package com.apexon.upskill.mcq.test.entity;

//public class Assessment {
//}

import com.apexon.upskill.mcq.entity.Question;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
public class Assessment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String assessmentName;

    @ManyToMany
    @JoinTable(
            name = "assessment_questions",
            joinColumns = @JoinColumn(name = "assessment_id"),
            inverseJoinColumns = @JoinColumn(name = "question_id")
    )
    private Set<Question> questions;
}

